package ua.kata

import org.scalatest.{FunSuite, Matchers}

class BinaryTreeTest extends FunSuite with Matchers {
  private val tree: Tree[Int] = Tree[Int]()

  test("create an empty tree") {
    tree.size shouldBe 0
  }

  test("add single item to a tree") {
    (tree + 10).size shouldBe 1
  }

  test("add many items to a tree") {
    (tree + 10 + 20 + 30).size shouldBe 3
  }

  test("traverse tree in order") {
    (tree + 5 + 2 + 1 + 4 + 7 + 6 + 8).inOrder should
      contain theSameElementsInOrderAs List(1, 2, 4, 5, 6, 7, 8)
  }

  test("traverse tree pre order") {
    (tree + 5 + 2 + 1 + 4 + 7 + 6 + 8).preOrder should
      contain theSameElementsInOrderAs List(5, 2, 1, 4, 7, 6, 8)
  }

  test("traverse tree post order") {
    (tree + 5 + 2 + 1 + 4 + 7 + 6 + 8).postOrder should
      contain theSameElementsInOrderAs List(1, 4, 2, 6, 8, 7, 5)
  }

  test("reduce in order") {
    (tree + 5 + 2 + 1 + 4 + 7 + 6 + 8).reduceInOrder(List[Int]())((acc, item) => item :: acc) should
      contain theSameElementsInOrderAs List(1, 2, 4, 5, 6, 7 ,8)
  }

  test("reduce pre order") {
    (tree + 5 + 2 + 1 + 4 + 7 + 6 + 8).reducePreOrder(List[Int]())((acc, item) => item :: acc) should
      contain theSameElementsInOrderAs List(5, 2, 1, 4, 7, 6, 8)
  }

  test("reduce post order") {
    (tree + 5 + 2 + 1 + 4 + 7 + 6 + 8).reducePostOrder(List[Int]())((acc, item) => item :: acc) should
      contain theSameElementsInOrderAs List(1, 4, 2, 6, 8, 7, 5)
  }
}
