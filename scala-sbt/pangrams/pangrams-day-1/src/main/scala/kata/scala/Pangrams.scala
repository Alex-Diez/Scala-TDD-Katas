package kata.scala

object Pangrams {
    private val letters = 'a' to 'z'

    def isPangram(string: String): Boolean = {
        letters.toIterator.forall(c => string.contains(c) || string.contains(c.toTitleCase))
    }

}
