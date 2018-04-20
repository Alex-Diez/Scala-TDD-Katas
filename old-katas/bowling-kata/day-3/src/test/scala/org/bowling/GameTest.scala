package org.bowling

import org.scalatest.{BeforeAndAfter, FunSuite}

class GameTest extends FunSuite with BeforeAndAfter {

    var game = new Game

    before {
        game = new Game
    }

    def rollMany(g: Game, times: Int, pins: Int) = {
        for(i <- 0 until times) {
            game.roll(pins)
        }
    }

    test("let's roll a ball ... gutter game :(") {
        rollMany(game, 20, 0)

        assert(game.score == 0)
    }

    test("let's roll the ball again ... all ones ... a little better") {
        rollMany(game, 20, 1)

        assert(game.score == 20)
    }

    test("let's roll ... one spare ... previous result was better :(") {
        game.roll(5)
        game.roll(5)
        game.roll(3)
        rollMany(game, 17, 0)

        assert(game.score == 16)
    }

    test("one strike ... my first strike ;)") {
        game.roll(10)
        game.roll(3)
        game.roll(4)
        rollMany(game, 16, 0)

        assert(game.score == 24)
    }

    test("perfect game ... best shot :D") {
        rollMany(game, 20, 10)

        assert(game.score == 300)
    }
}
