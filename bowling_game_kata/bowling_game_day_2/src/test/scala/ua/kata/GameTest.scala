package ua.kata

import org.scalatest.{FlatSpec, Matchers, BeforeAndAfterEach}

class GameTest extends FlatSpec with Matchers with BeforeAndAfterEach {
  var game: Game = _

  override def beforeEach(): Unit = {
    game = new Game
  }

  private def rollMany(times: Int, pin: Int): Unit =
    (1 to times).foreach(_ => game.roll(pin))

  private def rollSpare(): Unit = {
    game.roll(4)
    game.roll(6)
  }

  private def rollStrike(): Unit = game.roll(10)

  "Gutter game" should "have zero score" in {
    rollMany(20, 0)

    game.score() should be (0)
  }

  "All ones game" should "have score 20" in {
    rollMany(20, 1)

    game.score() should be (20)
  }

  "Game with one spare" should "have score 16" in {
    rollSpare()
    game.roll(3)
    rollMany(17, 0)

    game.score() should be (16)
  }

  "Game with one strike" should "have score 24" in {
    rollStrike()
    game.roll(4)
    game.roll(3)
    rollMany(16, 0)

    game.score() should be (24)
  }

  "Perfect game" should "have score 300" in {
    rollMany(12, 10)

    game.score() should be (300)
  }
}
