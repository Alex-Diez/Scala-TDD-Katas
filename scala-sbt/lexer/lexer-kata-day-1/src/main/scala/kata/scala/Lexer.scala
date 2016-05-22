package kata.scala

sealed abstract class Token {
}

case object NoToken extends Token

case class KeyWord(word: String) extends Token

case class Word(word: String) extends Token

case class Punctuation(symbol: Char) extends Token


class Lexer(private val src: String, private val keywords: Option[Set[String]]) {
    private val punctuationsSign = Set(',', ';')
    def this(src: String) = this(src, None)

    def next(): Token = {
        if (src.isEmpty) NoToken
        else keywords match {
            case Some(set) =>
                if (set.contains(src)) KeyWord(src)
                else Word(src)
            case None =>
                if (punctuationsSign.contains(src.charAt(0))) Punctuation(src.charAt(0))
                else Word(src)
        }
    }
}
