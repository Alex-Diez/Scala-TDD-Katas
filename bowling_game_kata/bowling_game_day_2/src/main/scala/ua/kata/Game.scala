package ua.kata

class Game {
  private var rolls: List[Int] = List()

  def roll(pin: Int): Unit = rolls = pin :: rolls

  def score(): Int = score(0, 1, rolls.reverse)

  private def score(current: Int, frame: Int, rolls: List[Int]): Int = {
    def isStrike: Boolean = rolls.head == 10

    def strikeBonus: Int = rolls.slice(1, 3).sum

    def isSpare: Boolean = framePoints == 10

    def spareBonus: Int = rolls.drop(2).head

    def framePoints: Int = rolls.take(2).sum

    def next: Int = frame + 1

    (frame, rolls) match {
      case (11, _) => current
      case (_, _ :: rest) if isStrike => score(10 + strikeBonus + current, next, rest)
      case (_, _ :: _ :: rest) if isSpare => score(10 + spareBonus + current, next, rest)
      case (_, _ :: _ :: rest) => score(current + framePoints, next, rest)
    }
  }
}
