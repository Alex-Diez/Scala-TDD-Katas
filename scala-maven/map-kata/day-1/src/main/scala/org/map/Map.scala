package org.map

class Map {
    private var elements: List[Element] = List()

    def get(key: Int): Option[Int] = {
        val eq = new Element(key, 0)
        for(elem <- elements) {
            if(elem == eq) {
                return Some(elem.value)
            }
        }
        None
    }
    def contains(key: Int): Boolean = elements.contains(new Element(key, 0))
    def remove(key: Int) = elements = elements.tail
    def put(key: Int, value: Int): Unit = elements = new Element(key, value) :: elements
    def size: Int = elements.size
    def isEmpty: Boolean = elements.isEmpty

    class Element(val key: Int, val value: Int) {
        override def equals(obj: Any): Boolean = {
            obj match {
                case that: Element => that.key == key
                case _ => false
            }
        }
    }
}

object Nil extends Map
