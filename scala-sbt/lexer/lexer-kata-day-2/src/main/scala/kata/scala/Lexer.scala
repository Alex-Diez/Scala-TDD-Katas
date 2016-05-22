package kata.scala

class Lexer(src: String) {
    def next(): Punctuation = { new Punctuation(';')}
}

case class Punctuation(symbol: Char) {}
