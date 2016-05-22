package kata.scala

import org.scalatest.{FlatSpec, FunSpec, Matchers}

class LexerTest extends FunSpec with Matchers {

    describe("lexer") {
        it("none from empty string") {
            val lexer = new Lexer("")

            lexer.next() shouldBe NoToken
        }

        it("return word from one word string") {
            val lexer = new Lexer("one")

            lexer.next() shouldBe Word("one")
        }

        it("return key word") {
            val lexer = new Lexer("insert", Some(Set("insert")))

            lexer.next() shouldBe KeyWord("insert")
        }

        describe("punctuation") {

            it("'Punctuation' coma") {
                val lexer = new Lexer(",")

                lexer.next() shouldBe Punctuation(',')
            }

            it ("'Punctuation' semicolon") {
                val lexer = new Lexer(";")

                lexer.next() shouldBe Punctuation(';')
            }
        }
    }
}
