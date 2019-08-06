package ua.kata

import org.scalatest.{Matchers, WordSpec}

class BinaryTreeTest extends WordSpec with Matchers {
  "A tree" when {
    "created" should {
      "have size 0" in {
        val tree = BinaryTree()

        tree should have size 0
      }
    }

    "added an item" should {
      val empty = BinaryTree()
      "have size 1" in {
        val tree: BinaryTree = empty.add(1)

        tree should have size 1
      }

      "contain it" in {
        val tree: BinaryTree = empty.add(1)

        tree should contain(1)
      }
    }

    "added many items" should {
      val empty = BinaryTree()
      "have size equal number of added items" in {
        val tree: BinaryTree = empty.add(1).add(2).add(3)

        tree should have size 3
      }

      "contain all of them" in {
        val tree: BinaryTree = empty.add(1).add(2).add(3)

        tree should contain(1)
        tree should contain(2)
        tree should contain(3)
      }
    }

    "traversed" should {
      val tree = BinaryTree(6, 2, 1, 4, 3, 5, 7, 9, 8)
      "in order" in {
        tree.inOrder should contain theSameElementsInOrderAs List(1, 2, 3, 4, 5, 6, 7, 8, 9)
      }

      "pre order" in {
        tree.preOrder should contain theSameElementsInOrderAs List(6, 2, 1, 4, 3, 5, 7, 9, 8)
      }

      "post order" in {
        tree.postOrder should contain theSameElementsInOrderAs List(1, 3, 5, 4, 2, 8, 9, 7, 6)
      }
    }
  }

}
