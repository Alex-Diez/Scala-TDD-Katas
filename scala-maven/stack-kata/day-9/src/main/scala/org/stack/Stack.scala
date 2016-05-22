package org.stack

class Stack[+T] {
    private var head: Element[T] = Nil
    def pop = {
        val r = head.value
        head = head.previous
        r
    }
    def push(value: T) = {
        head = new Data(head.index + 1, value, head)
    }
    def size = head.index + 1
    def isEmpty = head == Nil

    trait Element[+T] {
        def index: Int
        def previous: Element
        def value: Option[T]
    }

    object Nil extends Element[Nothing] {
        override def index: Int = -1
        override def value: Option[T] = None
        override def previous: Element = this
    }

    class Data[+T](val index: Int, val v: T, val previous: Element[T]) extends Element[T] {
        override def value: Option[T] = Some(v)
    }

}

object Nil extends Stack[Nothing] {
}
