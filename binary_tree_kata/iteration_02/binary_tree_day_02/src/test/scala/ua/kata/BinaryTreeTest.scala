package ua.kata

import org.scalatest.{FunSuite, Matchers}

class BinaryTreeTest extends FunSuite with Matchers {
  test("create empty tree") {
    Tree().size shouldBe 0
  }

  test("add single item to a tree") {
    (Tree() + 10).size shouldBe 1
  }

  test("add multiple items to a tree") {
    (Tree() + 10 + 20 + 30).size shouldBe 3
  }

  test("tree in order traversal") {
    (Tree() + 5 + 2 + 1 + 4 + 7 + 6 + 8).inOrder should
      contain theSameElementsInOrderAs List(1, 2, 4, 5, 6, 7, 8)
  }

  test("traverse pre order") {
    (Tree() + 5 + 2 + 1 + 4 + 7 + 6 + 8).preOrder should
      contain theSameElementsInOrderAs List(5, 2, 1, 4, 7, 6, 8)
  }

  test("traverse post order") {
    (Tree() + 5 + 2 + 1 + 4 + 7 + 6 + 8).postOrder should
      contain theSameElementsInOrderAs List(1, 4, 2, 6, 8, 7, 5)
  }

  test("reduce post order") {
    (Tree() + 5 + 2 + 1 + 4 + 7 + 6 + 8).reducePostOrder(List())((acc, item) => item :: acc) should
      contain theSameElementsInOrderAs List(1, 4, 2, 6, 8, 7, 5)
  }
}
