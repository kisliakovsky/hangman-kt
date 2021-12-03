package org.kislyi.hangman

import java.util.*

class DequeLetterReader(private val letters: Deque<Char>): LetterReader {

    override fun hasNext() = letters.isNotEmpty()

    override fun next() : Char = letters.pop()

    override fun close() = Unit
}