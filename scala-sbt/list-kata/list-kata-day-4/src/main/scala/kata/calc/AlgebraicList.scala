package kata.calc

trait AlgebraicList {
    def :::(listTwo: AlgebraicList): AlgebraicList = {
        this
    }

    def ::(element: Int): AlgebraicList

    def apply(index: Int): Int

    def size: Int

    def isEmpty: Boolean
}

private class List(val element: Option[Int], val next: Option[AlgebraicList], val size: Int) extends AlgebraicList {
    override def ::(element: Int): AlgebraicList = new List(Some(element), Some(this), size + 1)

    override def apply(index: Int): Int = {
        if (index == 0) element match {
            case Some(e) => e
            case None => throw new IndexOutOfBoundsException
        }
        else next match {
            case Some(n) => n.apply(index - 1)
            case None => throw new IndexOutOfBoundsException
        }
    }

    override def isEmpty: Boolean = false
}

object AlgebraicList extends AlgebraicList {
    def apply: AlgebraicList = AlgebraicList

    override def ::(element: Int): AlgebraicList = new List(Some(element), Some(this), 1)

    override def size: Int = 0

    override def apply(index: Int): Int = throw new IndexOutOfBoundsException

    override def isEmpty: Boolean = true
}
