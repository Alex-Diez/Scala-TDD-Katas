package ua.kata

import scala.annotation.tailrec

class Game {
  private var rolls: List[Int] = List()

  def roll(pin: Int): Unit = {
    rolls = pin :: rolls
  }

  def score(): Int =
    scoreInternal(0, rolls.reverse, 1)

  @tailrec
  private def scoreInternal(score: Int, rolls: List[Int], frame: Int): Int = {
    def isStrke: Boolean = rolls.head == 10

    def strikeBonus: Int = rolls.slice(1, 3).sum

    def isSpare: Boolean = framePoints == 10

    def spareBonus: Int = rolls.drop(2).head

    def framePoints: Int = rolls.take(2).sum

    (frame, rolls) match {
      case (11, _) => score
      case (_, _ :: rest) if isStrke => scoreInternal(10 + strikeBonus + score, rest, frame + 1)
      case (_, _ :: _ :: rest) if isSpare => scoreInternal(10 + spareBonus + score, rest, frame + 1)
      case (_, _ :: _ :: rest) => scoreInternal(framePoints + score, rest, frame + 1)
    }
  }
}
