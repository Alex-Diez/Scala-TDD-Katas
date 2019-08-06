package ua.kata

import org.scalatest.{Matchers, WordSpec}

class BinaryTreeTest extends WordSpec with Matchers {

  val newlyCreatedTree: BinaryTree = BinaryTree()

  "A tree" when {
    "created" should {
      "be empty" in {
        newlyCreatedTree should have size 0
      }
    }

    "added an item" should {
      "contain it" in {
        val tree = newlyCreatedTree.add(1)

        tree should contain(1)
      }
    }

    "added many items" should {
      "contain all of them" in {
        val tree = newlyCreatedTree.add(2).add(1).add(3)

        tree should contain(2)
        tree should contain(1)
        tree should contain(3)
      }
    }
  }
}
