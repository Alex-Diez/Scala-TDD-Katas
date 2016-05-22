package kata.calc

object Calculator {
    def evaluate(src: String): Double = {
        def parseTerm(iterator: BufferedIterator[Char]): Double = {
            def parseArg(iterator: BufferedIterator[Char]): Double = {
                var list = List[Char]()
                while (iterator.nonEmpty && (('0' to '9').contains(iterator.head) || iterator.head == '.')) {
                    list = list :+ iterator.next
                }
                list.mkString.toDouble
            }
            val first = parseArg(iterator)
            if (iterator.nonEmpty)
                iterator.head match {
                    case '×' =>
                        iterator.next
                        first * parseArg(iterator)
                    case '÷' =>
                        iterator.next
                        first / parseArg(iterator)
                    case _ => first
                }
            else first
        }
        val iterator = src.iterator.buffered
        val first = parseTerm(iterator)
        if (iterator.nonEmpty) {
            iterator.head match {
                case '+' =>
                    iterator.next
                    first + parseTerm(iterator)
                case '-' =>
                    iterator.next
                    first - parseTerm(iterator)
            }
        }
        else first
    }
}
