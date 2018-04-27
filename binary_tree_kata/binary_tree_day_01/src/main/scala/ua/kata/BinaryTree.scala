package ua.kata

import java.util.NoSuchElementException

import scala.collection.AbstractIterator

sealed trait BinaryTree extends Iterable[Int] {
  def add(item: Int): BinaryTree
}

object BinaryTree {
  def apply(): BinaryTree = EmptyTree
}

private case object EmptyTree extends BinaryTree {
  override def add(item: Int): BinaryTree = NodeTree(item, EmptyTree, EmptyTree)

  override def size: Int = 0

  override def iterator: Iterator[Int] = EmptyIterator

  private object EmptyIterator extends AbstractIterator {
    override def hasNext: Boolean = false

    override def next(): Nothing = throw new NoSuchElementException
  }
}

private case class NodeTree(elem: Int, leftLeaf: BinaryTree, rightLeaf: BinaryTree) extends BinaryTree {
  override def add(item: Int): BinaryTree = {
    if (item > this.elem) {
      NodeTree(this.elem, leftLeaf, rightLeaf.add(item))
    } else if (item < this.elem) {
      NodeTree(this.elem, leftLeaf.add(item), rightLeaf)
    } else {
      this
    }
  }

  override def iterator: Iterator[Int] = {
    def loop(node: BinaryTree): List[Int] = {
      node match {
        case EmptyTree => List()
        case NodeTree(item, left, right) => item :: loop(left) ++ loop(right)
      }
    }
    loop(this).iterator
  }
}
