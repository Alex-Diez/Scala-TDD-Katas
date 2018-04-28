package ua.kata

import org.scalatest.{Matchers, WordSpec}

class BinaryTreeTest extends WordSpec with Matchers {
  private val emptyTree: BinaryTree = BinaryTree()

  "A Tree" when {
    "created" should {
      "be empty" in {
        emptyTree should have size 0
      }
    }

    "added an item" should {
      "increase its size" in {
        val tree: BinaryTree = emptyTree.add(1)

        tree should have size 1
      }

      "contain it" in {
        val tree: BinaryTree = emptyTree.add(1)

        tree should contain(1)
      }
    }

    "add many items" should {
      "contain all of them" in {
        val tree: BinaryTree = emptyTree.add(2).add(1).add(3)

        tree should contain(1)
        tree should contain(2)
        tree should contain(3)
      }
    }
  }

  "Tree traversal" when {
    "in preorder" should {
      "begin from root to left to right leafs" in {
        val tree: BinaryTree = emptyTree.add(4).add(6).add(5).add(7).add(2).add(1).add(3)

        tree.preOrder should contain theSameElementsInOrderAs List(4, 2, 1, 3, 6, 5, 7)
      }
    }

    "in order" should {
      "begin from the most left to root to the most right" in {
        val tree: BinaryTree = emptyTree.add(4).add(6).add(5).add(7).add(2).add(1).add(3)

        tree.inOrder should contain theSameElementsInOrderAs List(1, 2, 3, 4, 5, 6, 7)
      }
    }
  }
}
