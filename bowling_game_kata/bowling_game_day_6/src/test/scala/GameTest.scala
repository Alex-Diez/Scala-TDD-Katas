package ua.kata

import org.scalatest.{FlatSpec, Matchers, BeforeAndAfterEach}

class GameTest extends FlatSpec with Matchers with BeforeAndAfterEach {
  var game: Game = _

  override def beforeEach(): Unit = game = new Game

  private implicit def toTestGame(game: Game): TestGame = new TestGame(game)

  "Gutter game" should "have score 0" in {
    game.rollMany(20, 0)

    game.score() should be (0)
  }

  "All ones game" should "have score 20" in {
    game.rollMany(20, 1)

    game.score() should be (20)
  }

  "Game with spare" should "have bonus equals to the next roll after spare frame" in {
    game.rollSpare()
    game.roll(3)
    game.rollMany(17, 0)

    game.score() should be (16)
  }

  "Game with strike" should "have bonus equals to the next two rolls after strike frame" in {
    game.rollStrike()
    game.roll(3)
    game.roll(4)
    game.rollMany(16, 0)

    game.score() should be (24)
  }

  "Perfect game" should "have score 300" in {
    game.rollMany(12, 10)

    game.score() should be (300)
  }
}

private class TestGame(game: Game) {
  def rollMany(times: Int, pin: Int): Unit =
    (1 to times).foreach(_ => game.roll(pin))

  def rollSpare(): Unit = {
    game.roll(4)
    game.roll(6)
  }

  def rollStrike(): Unit =
    game.roll(10)
}
