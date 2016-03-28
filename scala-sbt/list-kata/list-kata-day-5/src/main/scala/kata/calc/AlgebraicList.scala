package kata.calc

import scala.annotation.tailrec

trait AlgebraicList[T] {
    def ::(value: T): AlgebraicList[T] = new NonEmptyList[T](Some(value), Some(this), size + 1)

    def apply(index: Int): Option[T] = {
        @tailrec
        def find(index: Int, list: Option[AlgebraicList[T]]): Option[T] = {
            list match {
                case Some(l) =>
                    if (index == 0) l.value
                    else find(index - 1, l.next)
                case None => None
            }
        }
        find(index, Some(this))
    }

    def size: Int

    def isEmpty: Boolean = size == 0

    def head: Option[T]

    def tail: Option[AlgebraicList[T]]

    def value: Option[T]

    def next: Option[AlgebraicList[T]]
}

private class EmptyList[T] extends AlgebraicList[T] {
    override def size: Int = 0

    override def head: Option[T] = None

    override def tail: Option[AlgebraicList[T]] = None

    override def value: Option[T] = None

    override def next: Option[AlgebraicList[T]] = None

    override def equals(that: Any): Boolean = {
        that match {
            case that: EmptyList[T] => true
            case _ => false
        }
    }
}

private class NonEmptyList[T](val value: Option[T], val next: Option[AlgebraicList[T]], val size: Int) extends AlgebraicList[T] {
    override def head: Option[T] = value

    override def tail: Option[AlgebraicList[T]] = next

    override def equals(that: Any): Boolean = {
        that match {
            case that: NonEmptyList[T] => value == that.value && that.next == next
            case _ => false
        }
    }
}

object AlgebraicList {
    def apply[T](): AlgebraicList[T] = new EmptyList[T]
}
