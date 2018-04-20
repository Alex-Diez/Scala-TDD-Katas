package org.calc

import scala.collection.mutable

class Calculator() {
    var position = 0

    def evaluate(line: String): Double = {
        parseExpression(line)
    }

    private def parseExpression(line: String): Double = {
        var value = parseTerm(line)
        while (line.length > position) {
            value = line.charAt(position) match {
                case '+' => doAddition(value, line)
                case '-' => doSubstitution(value, line)
                case _ => return value
            }
        }
        value
    }

    private def doAddition(value: Double, line: String):Double = {
        position += 1
        value + parseTerm(line)
    }

    private def doSubstitution(value: Double, line: String):Double = {
        position += 1
        value - parseTerm(line)
    }

    private def parseTerm(line: String): Double = {
        var value = parseArg(line)
        while (line.length > position) {
            value = line.charAt(position) match {
                case '*' => doMultiplication(value, line)
                case '/' => doDivision(value, line)
                case _ => return value
            }
        }
        value
    }

    private def doMultiplication(value: Double, line: String):Double = {
        position += 1
        value * parseArg(line)
    }

    private def doDivision(value: Double, line: String):Double = {
        position += 1
        value / parseArg(line)
    }

    private def parseArg(line: String): Double = {
        val value = new mutable.StringBuilder
        var c = line.charAt(position)
        while (c == '.' || c == '(' ||  ('0' to '9').contains(c) && line.length > position) {
            if(c == '(') {
                position += 1
                val result = parseExpression(line)
                position += 1
                return  result
            }
            value append c
            position += 1
            if (line.length > position) {
                c = line.charAt(position)
            }
        }
        value.toDouble
    }
}
