package kata.calc

import kata.calc.Calculator.evaluate
import org.scalatest.{FlatSpec, Matchers}

class StringCalculatorTest extends FlatSpec with Matchers {

    it should " evaluate integer number " in {
        evaluate("1023") shouldBe 1023
    }

    it should " evaluate float number " in {
        evaluate("123.435") shouldBe 123.435
    }

    it should " evaluate addition " in {
        evaluate("324+213") shouldBe (324+213)
    }

    it should " evaluate subtraction " in {
        evaluate("345.6547-213.543") shouldBe (345.6547-213.543)
    }

    it should "evaluate multiplication" in {
        evaluate("4395×5") shouldBe 4395*5
    }

    it should " evaluate division " in {
        evaluate("435÷5") shouldBe 435/5
    }

    it should "evaluate number of operations" in {
        evaluate("3243+543-21-12821÷435+15×28") shouldBe (3243.0+543-21-12821.0/435+15*28)
    }

}
