package org.bowling

class Game {
    private var rolls: List[Int] = List()

    def roll(pins: Int): Unit = rolls = rolls :+ pins

    def score(): Int = {
        var sum = 0
        var frameIndex = 0
        for (frame <- 0 until 10) {
            if (isStrike(frameIndex)) {
                sum += rolls(frameIndex) + rolls(frameIndex + 1) + rolls(frameIndex + 2)
                frameIndex += 1
            }
            else if (isSpare(frameIndex)) {
                sum += rolls(frameIndex) + rolls(frameIndex + 1) + rolls(frameIndex + 2)
                frameIndex += 2
            }
            else {
                sum += rolls(frameIndex) + rolls(frameIndex + 1)
                frameIndex += 2
            }
        }
        sum
    }

    private def isStrike(frameIndex: Int): Boolean = rolls(frameIndex) == 10

    private def isSpare(frameIndex: Int): Boolean = rolls(frameIndex) + rolls(frameIndex + 1) == 10
}
