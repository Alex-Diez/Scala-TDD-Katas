package org.stack

class Stack[T] {
    private var head: Element[T] = new Empty[T]

    def isEmpty: Boolean = head.value.isEmpty

    def push(e: T) = head = new NonEmpty[T](e, head)

    def pop: Option[T] = {
        val r = head.value
        if(head.previous.isDefined) {
            head = head.previous.get
        }
        r
    }
}

private trait Element[T] {

    def previous: Option[Element[T]]

    def value: Option[T]
}

private class Empty[T] extends Element[T] {

    override def previous: Option[Element[T]] = None

    override def value: Option[T] = None
}

private class NonEmpty[T](val e: T, val p: Element[T]) extends Element[T] {

    override def previous: Option[Element[T]] = Some(p)

    override def value: Option[T] = Some(e)
}
