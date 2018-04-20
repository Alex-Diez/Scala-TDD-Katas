package kata.calc

trait AlgebraicList[T] {
    def :::(other: AlgebraicList[T]) = {
        def add(source: AlgebraicList[T], dest: AlgebraicList[T]): AlgebraicList[T] = {
            source match {
                case source: EmptyList[T] => dest
                case source: NonEmptyList[T] => source.next match {
                    case Some(list) => source.value.iterator.next() :: add(list, dest)
                    case _ => dest
                }
            }
        }
        add(other, add(this, new EmptyList[T]))
    }

    def ::(element: T): AlgebraicList[T] = new NonEmptyList(Some(element), size + 1, Some(this))

    def apply(index: Int): Option[T]

    def size: Int

    def isEmpty: Boolean = size == 0
}

class NonEmptyList[T](val value: Option[T], val size: Int, val next: Option[AlgebraicList[T]]) extends AlgebraicList[T] {
    override def apply(index: Int): Option[T] = {
        if (index == 0) value
        else next match {
            case Some(n) => n.apply(index - 1)
            case None => None
        }
    }

    override def equals(that: Any): Boolean = {
        that match {
            case that: NonEmptyList[T] => (that.value == value) && ((that.next, next) match {
                case (Some(thatNext), Some(thisNext)) => thatNext.equals(thisNext)
                case (None, None) => true
                case (_, _) => false
            })
            case _ => false
        }
    }

    override def toString: String = {
        next match {
            case Some(list) => list match {
                case list: NonEmptyList[T] => value + " -> " + list.toString
                case _ => value.toString
            }
            case None => ""
        }
    }
}

class EmptyList[T] extends AlgebraicList[T] {
    override def apply(index: Int): Option[T] = None

    override def size: Int = 0

    override def equals(that: Any): Boolean = {
        that match {
            case that: EmptyList[T] => true
            case _ => false
        }
    }

    override def toString: String = ""
}

object AlgebraicList {

    def apply[T](): AlgebraicList[T] = new EmptyList[T]
}
