package kata.calc

object Calculator {
    private val operation = Set('+', '-', '×', '÷')
    private val highOrderOperand = Set('×', '÷')

    def evaluate(src: String): Double = {
        def parseTerm(iterator: BufferedIterator[Char]): Double = {
            var result = parseArg(iterator)
            while (iterator.nonEmpty && highOrderOperand.contains(iterator.head))
                iterator.next match {
                    case '×' => result *= parseArg(iterator)
                    case '÷' => result /= parseArg(iterator)
                }
            result
        }
        def parseArg(iterator: BufferedIterator[Char]): Double = {
            var list: List[Char] = List()
            while (iterator.nonEmpty && !operation.contains(iterator.head)) {
                list = list :+ iterator.next
            }
            list.mkString.toDouble
        }
        val iterator = src.iterator.buffered
        var result = parseTerm(iterator)
        while (iterator.hasNext)
            iterator.next match {
                case '+' => result += parseTerm(iterator)
                case '-' => result -= parseTerm(iterator)
            }
        result
    }

}
