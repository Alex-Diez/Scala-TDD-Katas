package ua.kata

sealed trait BinaryTree extends Iterable[Int] {
  def add(item: Int): BinaryTree

  def inOrder: Seq[Int] = {
    def inOrder(node: Node): List[Int] = {
      (loop(node.leftSubTree, inOrder) :+ node.elem) ++ loop(node.rightSubTree, inOrder)
    }
    loop(this, inOrder)
  }

  def preOrder: Seq[Int] = {
    def preOrder(node: Node): List[Int] = {
      node.elem :: loop(node.leftSubTree, preOrder) ++ loop(node.rightSubTree, preOrder)
    }
    loop(this, preOrder)
  }

  def postOrder: Seq[Int] = {
    def postOrder(node: Node): List[Int] = {
      (loop(node.leftSubTree, postOrder) ++ loop(node.rightSubTree, postOrder)) :+ node.elem
    }
    loop(this, postOrder)
  }

  private def loop(tree: BinaryTree, onNode: Node => List[Int]): List[Int] = {
    tree match {
      case Leaf => List()
      case node: Node => onNode(node)
    }
  }
}

object BinaryTree {
  def apply(): BinaryTree = Leaf

  def apply(items: Int*): BinaryTree = items.foldLeft(apply())((tree, item) => tree.add(item))
}

private case object Leaf extends BinaryTree {
  override def add(item: Int): BinaryTree = Node(item, Leaf, Leaf)

  override def iterator: Iterator[Int] = Array().toIterator
}

private case class Node(elem: Int, leftSubTree: BinaryTree, rightSubTree: BinaryTree) extends BinaryTree {
  override def add(item: Int): BinaryTree = {
    if (item < elem) {
      Node(elem, leftSubTree.add(item), rightSubTree)
    } else if (item > elem) {
      Node(elem, leftSubTree, rightSubTree.add(item))
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
