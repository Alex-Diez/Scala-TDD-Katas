package org.stack

class Stack[+T] {
//    private var head: Element[T] = Nil

//    def size: Int = head.index + 1

//    def isEmpty: Boolean = head == Nil

//    def push(v: T) = {
//        head = new Data(head.index+1, v, head)
//    }

//    def pop: Option[T] = {
//        val r = head.value
//        head = head.previous
//        r
//    }

//    trait Element[E >: T] {
//        def index: Int
//
//        def previous: Element[E]
//
//        def value: Option[E]
//    }
//
//    object Nil extends Element[Nothing] {
//        def index: Int = -1
//
//        def previous: Element[Nothing] = this
//
//        def value: Option[Nothing] = None
//    }

//    class Data[+E >: T](val index: Int, val v: E, val previous: Element[E]) extends Element[E] {
//
//        def value: Option[E] = Some(v)
//    }

}

object Nil extends Stack[Nothing] {
}
