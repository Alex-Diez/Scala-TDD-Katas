package ua.kata

sealed trait Tree {
  def size: Int

  def +(value: Int): Tree

  def inOrder(): Seq[Int]

  def preOrder(): Seq[Int]

  def postOrder(): Seq[Int]
}

object Tree {
  def apply(): Tree = Empty

  def apply(value: Int): Tree = Node(value)
}

private case object Empty extends Tree {
  override def size: Int = 0

  override def +(value: Int): Tree = Tree(value)

  override def inOrder(): Seq[Int] = List()

  override def preOrder(): Seq[Int] = List()

  override def postOrder(): Seq[Int] = List()
}

private case class Node(value: Int, left: Tree = Empty, right: Tree = Empty)
    extends Tree {
  override def size: Int = 1 + left.size + right.size
  override def +(value: Int): Tree =
    if (value < this.value) Node(this.value, left + value, right)
    else Node(this.value, left, right + value)

  override def inOrder(): Seq[Int] = {
    def inOrder(tree: Tree, items: List[Int]): List[Int] =
      tree match {
        case Node(value, left, right) =>
          inOrder(left, value :: inOrder(right, items))
        case Empty => items
      }
    inOrder(this, List())
  }

  override def preOrder(): Seq[Int] = {
    def preOrder(tree: Tree, items: List[Int]): List[Int] =
      tree match {
        case Node(value, left, right) =>
          value :: preOrder(left, preOrder(right, items))
        case Empty => items
      }

    preOrder(this, List())
  }

  override def postOrder(): Seq[Int] = {
    def postOrder(tree: Tree, items: List[Int]): List[Int] = {
      tree match {
        case Node(value, left, right) => postOrder(right, postOrder(left, items)) :+ value
        case Empty =>items
      }
    }

    postOrder(this, List())
  }
}
