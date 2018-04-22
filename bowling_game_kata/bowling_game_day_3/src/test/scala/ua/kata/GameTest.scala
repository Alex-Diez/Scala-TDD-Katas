package ua.kata

import org.scalatest.{FlatSpec, Matchers, BeforeAndAfterEach}

class GameTest extends FlatSpec with Matchers with BeforeAndAfterEach {
  private var game: Game = _

  override def beforeEach(): Unit = 
    game = new Game

  private implicit def wrapper(game: Game): RichGame = new RichGame(game)

  "Gutter game" should "have score 0" in {
    game.rollMany(20, 0)

    game.score() should be (0)
  }

  "All ones game" should "have score 20" in {
    game.rollMany(20, 1)

    game.score() should be (20)
  }

  "Player" should "have bonus of next roll when roll spare" in {
    game.rollSpare()
    game.roll(3)
    game.rollMany(17, 0)

    game.score() should be (16)
  }

  it should "have bonus of two next rolls when roll strike" in {
    game.rollStrike()
    game.roll(4)
    game.roll(3)
    game.rollMany(16, 0)

    game.score() should be (24)
  }

  "Perfect game" should "have score 300" in {
    game.rollMany(12, 10)

    game.score() should be (300)
  }
}

class RichGame(game: Game) {
  def rollMany(times: Int, pin: Int): Unit = (1 to times).foreach(_ => game.roll(pin))

  def rollSpare(): Unit = {
    game.roll(4)
    game.roll(6)
  }

  def rollStrike(): Unit = game.roll(10)
}
