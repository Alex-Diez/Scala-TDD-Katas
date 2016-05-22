package kata.calc

trait AlgebraicList[T] {
    def ::(element: T): AlgebraicList[T] = new NonEmptyList[T](Some(element), Some(this), size + 1)

    def apply(index: Int): Option[T]

    def isEmpty: Boolean

    def size: Int

    def head: Option[T]

    def tail: Option[AlgebraicList[T]]
}

private class NonEmptyList[T](val value: Option[T], val next: Option[AlgebraicList[T]], val size: Int) extends AlgebraicList[T] {

    def apply(index: Int): Option[T] = {
        if (index == 0) value
        else next match {
            case Some(n) => n.apply(index - 1)
            case None => None
        }
    }

    def isEmpty: Boolean = true

    def head: Option[T] = value

    def tail: Option[AlgebraicList[T]] = next

    override def equals(other: Any): Boolean = {
        other match {
            case other: NonEmptyList[T] =>
                (value == other.value) && (
                        (other.next, this.next) match {
                            case (Some(oNext), Some(thisNext)) => oNext.equals(thisNext)
                            case (None, None) => true
                            case (_, _) => false
                        }
                )
            case other: EmptyList[T] => false
        }
    }
}

private class EmptyList[T] extends AlgebraicList[T] {
    def isEmpty: Boolean = true

    def size: Int = 0

    def apply(index: Int): Option[T] = None

    def head: Option[T] = None

    def tail: Option[AlgebraicList[T]] = None

    override def equals(other: Any): Boolean = {
        other match {
            case other: EmptyList[T] => true
            case _ => false
        }
    }
}

object AlgebraicList {
    def apply[T](): AlgebraicList[T] = new EmptyList[T]
}
