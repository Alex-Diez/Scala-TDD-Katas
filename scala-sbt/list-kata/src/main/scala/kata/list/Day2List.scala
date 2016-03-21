package kata.list

import scala.annotation.tailrec

class Day2List(val elem: Option[Int], var next: Option[Day2List], val size: Int) {
  def this() {
    this(None, None, 0)
  }

  def isEmpty: Boolean = size == 0

  def apply(index: Int): Int = {
    @tailrec
    def find(index: Int, element: Option[Day2List]): Int = {
      element match {
        case Some(e) =>
          if (index == 0) e.elem match {
            case Some(v) => v
            case None => throw new IndexOutOfBoundsException
          }
          else element match {
            case Some(l) => find(index - 1, l.next)
            case None => throw new IndexOutOfBoundsException
          }
        case  None => throw new IndexOutOfBoundsException
      }
    }
    find(index, Some(this))
  }

  def ::(elem: Int): Day2List = {
    new Day2List(Some(elem), Some(this), size + 1)
  }

  def ::: (other: Day2List): Day2List = {
    @tailrec
    def last(list: Day2List): Day2List = {
      list.next match {
        case Some(n) => n.next match {
          case Some(l) => last(n)
          case None => list
        }
      }
    }
    val lastE = last(other)
    lastE.next = Some(this)
    other
  }

  override def toString: String = next match {
    case Some(n) => elem.toString + " -> " + n.toString
    case None => elem.toString
  }

  override def equals(any: Any): Boolean = {
    @tailrec
    def equal(listOne: Option[Day2List], listTwo: Option[Day2List]): Boolean = {
      (listOne, listTwo) match {
        case (Some(lOne), Some(lTwo)) => (lOne.elem, lTwo.elem) match {
          case (Some(eOne), Some(eTwo)) => eOne == eTwo && equal(lOne.next, lTwo.next)
          case (None, None) => true
          case _ => false
        }
        case _ => false
      }

    }
    any match {
      case that: Day2List => equal(Some(this), Some(that))
      case _ => false
    }
  }
}
