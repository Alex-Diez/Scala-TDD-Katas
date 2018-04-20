package org.bowling

class Game {
    private var rolls: List[Int] = List()

    def roll(pins: Int): Unit = {
        rolls = pins :: rolls
    }

    def score: Int = {
        rolls = (0 :: rolls).reverse
        var sum = 0
        var frameIndex = 0
        for (frame <- 0 until 10) {
            if (isStrike(frameIndex)) {
                sum += strikePoints(frameIndex)
                frameIndex += 1
            }
            else if (isSpare(frameIndex)) {
                sum += sparePoints(frameIndex)
                frameIndex += 2
            }
            else {
                sum += framePoints(frameIndex)
                frameIndex += 2
            }
        }
        sum
    }

    private def sparePoints(frameIndex: Int): Int = 10 + rolls(frameIndex + 2)

    private def strikePoints(frameIndex: Int): Int = 10 + rolls(frameIndex + 1) + rolls(frameIndex + 2)

    private def isStrike(frameIndex: Int): Boolean = rolls(frameIndex) == 10

    private def isSpare(frameIndex: Int): Boolean = rolls(frameIndex) + rolls(frameIndex + 1) == 10

    private def framePoints(frameIndex: Int):Int = rolls(frameIndex) + rolls(frameIndex + 1)
}
