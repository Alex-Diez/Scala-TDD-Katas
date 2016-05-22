package org.map

class Map {
    var len = 0
    private var head: Element = Empty

    private def contains(key: Int, elem: Element): Boolean = {
        if(elem == Empty) false
        else if(elem.key == key) true
        else contains(key, elem.next)
    }
    def size(): Int = len
    def isEmpty(): Boolean = size == 0
    def put(key: Int, value: Int):Unit = {
        if(!contains(key, head)) {
            head = new Cons(key, value, head, head.index + 1)
            len += 1
        }
    }
    def remove(i: Int) = {
        len -= 1
    }

    trait Element {
        def key(): Int
        def value(): Int
        def next(): Element
        def index(): Int
    }

    object Empty extends Element {
        override def key() = throw new NoSuchElementException
        override def value() = throw new NoSuchElementException
        override def next() = this
        override def index() = 0
    }

    class Cons(val key: Int, val value: Int, val next: Element, val index: Int) extends Element {
    }

}
