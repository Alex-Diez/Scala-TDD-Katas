package ua.kata


sealed trait BinaryTree extends Iterable[Int] {
  def add(item: Int): BinaryTree

  def inOrder: Seq[Int] = {
    def preOrder(item: Int, left: BinaryTree, right: BinaryTree): List[Int] = {
      (loop(left, preOrder) :+ item) ++ loop(right, preOrder)
    }

    loop(this, preOrder)
  }

  def preOrder: Seq[Int] = {
    def preOrder(item: Int, left: BinaryTree, right: BinaryTree): List[Int] = {
      item :: loop(left, preOrder) ++ loop(right, preOrder)
    }

    loop(this, preOrder)
  }

  def postOrder: Seq[Int] = {
    def postOrder(item: Int, left: BinaryTree, right: BinaryTree): List[Int] = {
      (loop(left, postOrder) ++ loop(right, postOrder)) :+ item
    }

    loop(this, postOrder)
  }

  private def loop(tree: BinaryTree, onNode: (Int, BinaryTree, BinaryTree) => List[Int]): List[Int] = {
    tree match {
      case Leaf => List()
      case Node(item, left, right) => onNode(item, left, right)
    }
  }
}

object BinaryTree {
  def apply(): BinaryTree = Leaf

  def apply(items: Int*): BinaryTree = {
    items.foldLeft(apply())((tree, item) => tree.add(item))
  }
}

private case object Leaf extends BinaryTree {
  private val EMPTY_ITERATOR: Iterator[Int] = Array().iterator

  override def add(item: Int): BinaryTree = Node(item, Leaf, Leaf)

  override def iterator: Iterator[Int] = EMPTY_ITERATOR
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

  override def iterator: Iterator[Int] = {
    def loop(tree: BinaryTree): List[Int] = {
      tree match {
        case Leaf => List()
        case Node(item, left, right) => item :: loop(left) ++ loop(right)
      }
    }

    loop(this).toIterator
  }
}
