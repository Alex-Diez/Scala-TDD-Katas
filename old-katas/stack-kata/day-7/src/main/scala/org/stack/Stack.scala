package org.stack

class Stack[T](val maxSize: Int) {
    private var head: Element[T] = new Empty[T]

    def pop:Option[T] = {
        val r = head.value
        head = head.previous
        r
    }

    def push(v: T):Boolean = {
        if (maxSize != size) {
            head = new NonEmpty(head.index + 1, v, head)
            true
        }
        else false
    }

    def isEmpty = head.index == -1

    def size = head.index + 1

    trait Element[V] {
        def index: Int

        def previous: Element[V]

        def value: Option[V]
    }

    class Empty[V] extends Element[V] {
        override def index: Int = -1

        override def previous: Element[V] = this

        override def value: Option[V] = None
    }

    class NonEmpty[V](val index: Int, val v: V, val previous: Element[V]) extends Element[V] {
        override def value: Option[V] = Some(v)
    }

}
