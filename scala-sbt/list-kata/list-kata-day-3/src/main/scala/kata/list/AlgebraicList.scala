package kata.list

import scala.annotation.tailrec

class AlgebraicList(val value: Option[Int], var next: Option[AlgebraicList], val size: Int) {
    def this() {
        this(None, None, 0)
    }

    def ::(elem: Int): AlgebraicList = new AlgebraicList(Some(elem), Some(this), size + 1)

    def :::(other: AlgebraicList) = {
        def last(list: AlgebraicList): AlgebraicList = {
            list.next match {
                case Some(n) => n.next match {
                    case Some(l) => last(n)
                    case None => list
                }
            }
        }
        val lastElem = last(other)
        lastElem.next = Some(this)
        other
    }

    def apply(index: Int): Int = {
        @tailrec
        def find(index: Int, list: Option[AlgebraicList]): Int = {
            list match {
                case Some(l) => if (index == 0) {
                    l.value match {
                        case Some(v) => v
                        case None => throw new IndexOutOfBoundsException
                    }
                }
                else find(index - 1, l.next)
                case None => throw new IndexOutOfBoundsException
            }
        }
        find(index, Some(this))
    }

    def isEmpty: Boolean = size == 0

    @tailrec
    private def equal(listOne: Option[AlgebraicList], listTwo: Option[AlgebraicList]): Boolean = {
        (listOne, listTwo) match {
            case (Some(lOne), Some(lTwo)) => (lOne.value, lTwo.value) match {
                case (Some(vOne), Some(vTwo)) => vOne == vTwo && equal(lOne.next, lTwo.next)
                case (None, None) => true
            }
            case (None, None) => true
            case (_, _) => false
        }
    }

    override def equals(any: Any): Boolean = {
        any match {
            case that: AlgebraicList => equal(Some(that), Some(this))
            case _ => false
        }
    }

    override def toString: String = {
        next match {
            case Some(list) => list.next match {
                case Some(n) => value.toString + " -> " + list.toString
                case None => value.toString
            }
            case None => ""
        }
    }
}
