package org.kislyi.hangman

interface LetterReader : Iterator<Char>, AutoCloseable {

    class Fake(
        private val char: Char,
        var closed: Boolean = false
    ) : LetterReader {
        override fun hasNext() = true

        override fun next() = char

        override fun close() {
            closed = true
        }
    }
}