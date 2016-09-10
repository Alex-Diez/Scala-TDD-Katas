package kata.calc

import scala.annotation.tailrec

sealed trait AlgebraicList {
  def size: Int
  def isEmpty: Boolean = size == 0
  def apply(i: Int):Int
  def :: (ele: Int): AlgebraicList
  def value: Int
  def next: Option[AlgebraicList]
  def index: Int
}

private object EmptyList extends AlgebraicList {
  def size: Int = 0
  override def :: (ele: Int): AlgebraicList = new NonEmpty(0, ele, EmptyList)
  override def apply(i: Int): Int = throw new NoSuchElementException
  override def value: Int = throw new NoSuchElementException
  override def next: Option[AlgebraicList] = None
  override def index: Int = -1
}

private class NonEmpty(i: Int, v: Int, nextElem: AlgebraicList) extends AlgebraicList {
  def size: Int = i + 1
  override def :: (ele: Int): AlgebraicList = new NonEmpty(i + 1, ele, this)
  override def value: Int = v
  override def apply(i: Int): Int = {
    @tailrec
    def find(i: Int, current: Option[AlgebraicList]): AlgebraicList = {
      current match {
        case Some(l) =>
          if (i == 0) l
          else find(i - 1, l.next)
        case None => throw new NoSuchElementException
      }
    }
    find(i, Some(this)) value
  }
  override def next: Option[AlgebraicList] = Some(nextElem)
  override def index: Int = i
}

object AlgebraicList {
  def create: AlgebraicList = EmptyList
}
