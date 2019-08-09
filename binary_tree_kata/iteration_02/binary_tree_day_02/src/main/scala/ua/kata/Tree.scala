package ua.kata

trait Tree {
  def size(): Int

  def +(item: Int): Tree

  def inOrder(): Seq[Int] = inOrder(List()).reverse
  private[kata] def inOrder(items: List[Int]): List[Int]

  def preOrder(): Seq[Int] = preOrder(List())
  private[kata] def preOrder(items: List[Int]): List[Int]

  def postOrder(): Seq[Int] = reducePostOrder(List())((acc, item) => item :: acc)

  def reducePostOrder(
    init: List[Int]
  )(reducer: (List[Int], Int) => List[Int]): List[Int] = this match {
    case Node(item, left, right) =>
      left.reducePostOrder(
        right.reducePostOrder(reducer(init, item))(reducer)
      )(reducer)
    case Empty => init
  }
}

object Tree {
  def apply(): Tree = Empty
}

private case object Empty extends Tree {
  override def size(): Int = 0

  override def +(item: Int): Tree = Node(item)

  override private[kata] def inOrder(items: List[Int]): List[Int] = items

  override private[kata] def preOrder(items: List[Int]): List[Int] = items
}

private case class Node(item: Int, left: Tree = Empty, right: Tree = Empty)
    extends Tree {
  override def size(): Int = 1 + left.size() + right.size()

  override def +(item: Int): Tree =
    if (item < this.item) Node(this.item, left + item, right)
    else Node(this.item, left, right + item)

  override private[kata] def inOrder(items: List[Int]): List[Int] =
    right.inOrder(item :: left.inOrder(items))

  override private[kata] def preOrder(items: List[Int]): List[Int] =
    item :: left.preOrder(right.preOrder(items))
}
