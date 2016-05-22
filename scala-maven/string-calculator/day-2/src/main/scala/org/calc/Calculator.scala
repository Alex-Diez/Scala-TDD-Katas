package org.calc

class Calculator {
    var position: Int = 0
    val numberRange: Set[Char] = ('0' to '9').toSet

    def evaluate(line: String): Double = parseExpression(line)

    private def parseExpression(line: String): Double = {
        var value = parseTerm(line)
        while (line.length > position) {
            val sign = line.charAt(position)
            value = sign match {
                case '+' => doAddition(value, line)
                case '-' => doSubstitution(value, line)
                case _ => return value
            }
        }
        value
    }

    private def doAddition(value: Double, line: String): Double = {
        position += 1
        value + parseTerm(line)
    }

    private def doSubstitution(value: Double, line: String): Double = {
        position += 1
        value - parseTerm(line)
    }

    private def parseTerm(line: String): Double = {
        var value = parseArg(line)
        while (line.length > position) {
            val sign = line.charAt(position)
            value = sign match {
                case '*' => doMultiplication(value, line)
                case '/' => doDivision(value, line)
                case _ => return value
            }
        }
        value
    }

    private def doMultiplication(value: Double, line: String): Double = {
        position += 1
        value * parseArg(line)
    }

    private def doDivision(value: Double, line: String): Double = {
        position += 1
        value / parseArg(line)
    }

    private def parseArg(line: String): Double = {
        val v = new StringBuilder
        var c = line.charAt(position)
        while ((c == '.' || c == '(' || numberRange.contains(c)) && line.length > position) {
            position += 1
            if (c == '(') {
                val result = parseExpression(line)
                position += 1
                return result
            }
            v append c
            if (line.length > position) {
                c = line.charAt(position)
            }
        }
        v.toDouble
    }
}
