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
            var result = parseArg(iterator)
            while (iterator.nonEmpty && Set('×', '÷').contains(iterator.head)) {
                iterator.next match {
                    case '×' => result *= parseTerm(iterator)
                    case '÷' => result /= parseTerm(iterator)
                }
            }
            result
        }
        val iterator = src.iterator.buffered
        var result = parseTerm(iterator)
        while (iterator.nonEmpty && Set('+', '-').contains(iterator.head))
            iterator.next match {
                case '+' => result += parseTerm(iterator)
                case '-' => result -= parseTerm(iterator)
            }
        result
    }

}
