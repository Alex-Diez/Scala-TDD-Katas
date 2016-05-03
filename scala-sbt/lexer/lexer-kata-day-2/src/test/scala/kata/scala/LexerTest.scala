package kata.scala

import org.scalatest.{FunSpec, Matchers}

class LexerTest extends FunSpec with Matchers {

    it ("create a lexer") {
        new Lexer("")
    }

    describe("punctuation") {

        it ("return 'Punctuation' semicolon") {
            val lexer = new Lexer(";")

            lexer.next() shouldBe new Punctuation(';')
        }
    }
}
