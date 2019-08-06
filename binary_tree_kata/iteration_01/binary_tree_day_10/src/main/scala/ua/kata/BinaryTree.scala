package ua.kata

sealed trait BinaryTree extends Iterable[Int] {
  def add(item: Int): BinaryTree

  def inOrder: Seq[Int] = {
    def inOrder(node: Node): List[Int] = {
      (loop(node.leftTree, inOrder) :+ node.elem) ++ loop(node.rightTree, inOrder)
    }

    loop(this, inOrder)
  }

  def preOrder: Seq[Int] = {
    def preOrder(node: Node): List[Int] = {
      node.elem :: loop(node.leftTree, preOrder) ++ loop(node.rightTree, preOrder)
    }

    loop(this, preOrder)
  }

  def postOrder: Seq[Int] = {
    def postOrder(tree: Node): List[Int] = {
      (loop(tree.leftTree, postOrder) ++ loop(tree.rightTree, postOrder)) :+ tree.elem
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

  def apply(items: Int*): BinaryTree = {
    items.foldLeft(apply())((tree, item) => tree.add(item))
  }
}

private object Leaf extends BinaryTree {
  override def add(item: Int): BinaryTree = Node(item, Leaf, Leaf)

  override def iterator: Iterator[Int] = Array().toIterator
}

case class Node(elem: Int, leftTree: BinaryTree, rightTree: BinaryTree) extends BinaryTree {
  override def add(item: Int): BinaryTree = {
    if (item < elem) {
      Node(elem, leftTree.add(item), rightTree)
    } else if (item > elem) {
      Node(elem, leftTree, rightTree.add(item))
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
