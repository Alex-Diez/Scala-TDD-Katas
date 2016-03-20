package kata.list

import scala.annotation.tailrec

sealed trait Day1List {
  def size: Int
  def isEmpty: Boolean = size == 0
  def apply(i: Int):Int
  def :: (ele: Int): Day1List
  def value: Int
  def next: Option[Day1List]
  def index: Int
}

private object EmptyList extends Day1List {
  def size: Int = 0
  override def :: (ele: Int): Day1List = new NonEmpty(0, ele, EmptyList)
  override def apply(i: Int): Int = throw new NoSuchElementException
  override def value: Int = throw new NoSuchElementException
  override def next: Option[Day1List] = None
  override def index: Int = -1
}

private class NonEmpty(i: Int, v: Int, nextElem: Day1List) extends Day1List {
  def size: Int = i + 1
  override def :: (ele: Int): Day1List = new NonEmpty(i + 1, ele, this)
  override def value: Int = v
  override def apply(i: Int): Int = {
    @tailrec
    def find(i: Int, current: Option[Day1List]): Day1List = {
      current match {
        case Some(l) =>
          if (i == 0) l
          else find(i - 1, l.next)
        case None => throw new NoSuchElementException
      }
    }
    find(i, Some(this)) value
  }
  override def next: Option[Day1List] = Some(nextElem)
  override def index: Int = i
}

object Day1List {
  def create: Day1List = EmptyList
}
