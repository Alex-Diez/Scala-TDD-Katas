package ua.kata

import org.scalatest.{FunSuite, Matchers}

class BinaryTreeTest extends FunSuite with Matchers {
  private val emptyTree: BinaryTree = BinaryTree()

  test("created tree has size 0") {
    emptyTree should have size 0
  }

  test("tree contains added value") {
    val tree: BinaryTree = emptyTree.add(1)

    tree should contain(1)
  }

  test("tree has all added items") {
    val tree: BinaryTree = emptyTree.add(2).add(1).add(3)

    tree should contain(1)
    tree should contain(2)
    tree should contain(3)
  }

  private val traversable: BinaryTree = BinaryTree(6, 2, 1, 4, 3, 5, 7, 9, 8)

  test("traverse tree in order") {
    traversable.inOrder should contain theSameElementsInOrderAs List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  }

  test("traverse tree preorder") {
    traversable.preOrder should contain theSameElementsInOrderAs List(6, 2, 1, 4, 3, 5, 7, 9, 8)
  }

  test("traverse tree postorder") {
    traversable.postOrder should contain theSameElementsInOrderAs List(1, 3, 5, 4, 2, 8, 9, 7, 6)
  }
}
