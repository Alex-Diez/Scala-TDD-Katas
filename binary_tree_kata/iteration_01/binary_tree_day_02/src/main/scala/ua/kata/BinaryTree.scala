package ua.kata

sealed trait BinaryTree extends Iterable[Int] {
  def add(item: Int): BinaryTree

  def size: Int

  def preOrder: Seq[Int] = {
    def loop(node: BinaryTree): List[Int] = {
      node match {
        case Leaf => List()
        case Node(item, left, right) => item :: loop(left) ++ loop(right)
      }
    }
    loop(this)
  }

  def inOrder: Seq[Int] = {
    def loop(node: BinaryTree): List[Int] = {
      node match {
        case Leaf => List()
        case Node(item, left, right) => (loop(left) :+ item) ++ loop(right)
      }
    }
    loop(this)
  }
}

object BinaryTree {
  def apply(): BinaryTree = Leaf
}

private case object Leaf extends BinaryTree {
  override def add(item: Int): BinaryTree = Node(item, Leaf, Leaf)

  override def size: Int = 0

  override def iterator: Iterator[Int] = Array().toIterator
}

private case class Node(elem: Int, leftLeaf: BinaryTree, rightLeaf: BinaryTree) extends BinaryTree {
  override def add(item: Int): BinaryTree = {
    if (item < elem) {
      Node(elem, leftLeaf.add(item), rightLeaf)
    } else if (item > elem) {
      Node(elem, leftLeaf, rightLeaf.add(item))
    } else {
      this
    }
  }

  override def size: Int = 1

  override def iterator: Iterator[Int] = {
    def loop(node: BinaryTree): List[Int] = {
      node match {
        case Leaf => List()
        case Node(item, left, right) => item :: loop(left) ++ loop(right)
      }
    }
    loop(this).toIterator
  }
}
