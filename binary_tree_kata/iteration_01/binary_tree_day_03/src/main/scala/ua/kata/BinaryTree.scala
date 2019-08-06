package ua.kata

sealed trait BinaryTree extends Iterable[Int] {
  def add(item: Int): BinaryTree

  def size: Int

  def inOrder: Seq[Int] = {
    def loop(tree: BinaryTree): List[Int] = {
      tree match {
        case Leaf => List()
        case Node(item, left, right) => (loop(left) :+ item) ++ loop(right)
      }
    }
    loop(this)
  }

  def preOrder: Seq[Int] = {
    def loop(tree: BinaryTree): List[Int] = {
      tree match {
        case Leaf => List()
        case Node(item, left, right) => item :: loop(left) ++ loop(right)
      }
    }
    loop(this)
  }

  def postOrder: Seq[Int] = {
    def loop(tree: BinaryTree): Seq[Int] = {
      tree match {
        case Leaf => List()
        case Node(item, left, right) => loop(left) ++ loop(right) :+ item
      }
    }
    loop(this)
  }
}

object BinaryTree {
  def apply(): BinaryTree = Leaf

  def apply(items: Int*): BinaryTree = {
    var tree = apply()
    items.foreach(item => tree = tree.add(item))
    tree
  }
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

  override def size: Int = 1 + leftLeaf.size + rightLeaf.size

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
