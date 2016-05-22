package org.bowling

class Game {
    var frames: List[Frame] = List(new Frame)

    def roll(pins: Int) = {
        val frame = frames.last.roll(pins)
        if(frame != frames.last) {
            frames = frames :+ frame
        }
    }

//    def score:Int = (0 /: rolls)(_+_)
    def score:Int = {
        var sum = 0
        for (frameIndex <- 0 until 10) {
            val frame = frames(frameIndex)
            if(frame.isStrike) {
                sum += frame.first + frame.second + frames(frameIndex+1).first + frames(frameIndex+1).second
            }
            else if(frame.isSpare) {
                sum += frame.first + frame.second + frames(frameIndex+1).first
            }
            else {
                sum += frame.first + frame.second
            }
        }
        sum
    }

    class Frame {
        var first = -1
        var second = -1

        def roll(pins: Int): Frame = {
            if(first == -1 || second == -1) {
                if(first == -1) {
                    first = pins
                }
                else if(second == -1) {
                    second = pins
                }
                this
            }
            new Frame().roll(pins)
        }

        def isStrike: Boolean = first == 10

        def isSpare: Boolean = first + second == 10
    }
}
