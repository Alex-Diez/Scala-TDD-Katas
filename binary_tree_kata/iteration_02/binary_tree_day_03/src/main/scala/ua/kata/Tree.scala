package ua.kata

trait Tree[+E] {
  def size(): Int

  def +[T >: E](item: T)(implicit ord: Ordering[T]): Tree[T]

  def inOrder(): Seq[E] = reduceInOrder(List[E]())((acc, item) => item :: acc)

  def preOrder(): Seq[E] = reducePreOrder(List[E]())((acc, item) => item :: acc)

  def postOrder(): Seq[E] =
    reducePostOrder(List[E]())((acc, item) => item :: acc)

  def reduceInOrder[A](init: A)(reducer: (A, E) => A): A

  def reducePreOrder[A](init: A)(reducer: (A, E) => A): A

  def reducePostOrder[A](init: A)(reducer: (A, E) => A): A
}

object Tree {
  def apply[E]()(implicit ord: Ordering[E]): Tree[E] = Empty
}

private case object Empty extends Tree[Nothing] {
  override def size(): Int = 0

  override def +[T >: Nothing](item: T)(implicit ord: Ordering[T]): Tree[T] =
    Node[T](item)

  override def reduceInOrder[A](init: A)(reducer: (A, Nothing) => A): A = init

  override def reducePreOrder[A](init: A)(reducer: (A, Nothing) => A): A = init

  override def reducePostOrder[A](init: A)(reducer: (A, Nothing) => A): A = init
}

private case class Node[E](item: E,
                           left: Tree[E] = Empty,
                           right: Tree[E] = Empty)
    extends Tree[E] {
  override def size(): Int = 1 + left.size() + right.size()

  override def +[T >: E](item: T)(implicit ord: Ordering[T]): Tree[T] = {
    import ord._
    if (item < this.item) Node(this.item, left + item, right)
    else Node(this.item, left, right + item)
  }

  override def reduceInOrder[A](init: A)(reducer: (A, E) => A): A = {
    val rightTree: A = right.reduceInOrder(init)(reducer)
    val nodeReduced: A = reducer(rightTree, item)
    left.reduceInOrder(nodeReduced)(reducer)
  }

  override def reducePreOrder[A](init: A)(reducer: (A, E) => A): A = {
    val rightTree: A = right.reducePreOrder(init)(reducer)
    val leftTree: A = left.reducePreOrder(rightTree)(reducer)
    reducer(leftTree, item)
  }

  override def reducePostOrder[A](init: A)(reducer: (A, E) => A): A = {
    val nodeReduced: A = reducer(init, item)
    val rightTree: A = right.reducePostOrder(nodeReduced)(reducer)
    left.reducePostOrder(rightTree)(reducer)
  }
}
