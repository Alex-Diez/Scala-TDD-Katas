package org.bowling

class Game {
    var rolls: Array[Int] = new Array[Int](21)
    var index: Int = 0

    def roll(pins: Int): Unit = {
        rolls(index) = pins
        index += 1
    }

    def score(): Int = {
        var frameIndex = 0
        var sum = 0
        for (frame <- 0 until 10) {
            if (isStrike(frameIndex)) {
                sum = sum + strikePoints(frameIndex)
                frameIndex = frameIndex + 1
            } else if (isSpare(frameIndex)) {
                sum = sum + sparePoints(frameIndex)
                frameIndex = frameIndex + 2
            }
            else {
                sum = sum + rolls(frameIndex) + rolls(frameIndex + 1)
                frameIndex = frameIndex + 2
            }
        }
        sum
    }

    private def sparePoints(frameIndex: Int): Int = {
        10 + rolls(frameIndex + 2)
    }

    private def strikePoints(frameIndex: Int): Int = {
        10 + rolls(frameIndex + 1) + rolls(frameIndex + 2)
    }

    private def isStrike(frameIndex: Int): Boolean = {
        rolls(frameIndex) == 10
    }

    private def isSpare(frameIndex: Int): Boolean = {
        rolls(frameIndex) + rolls(frameIndex + 1) == 10
    }
}
