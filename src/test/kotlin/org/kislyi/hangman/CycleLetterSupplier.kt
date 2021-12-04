package org.kislyi.hangman

import java.util.*

class CycleLetterSupplier(
    private val letters: Queue<Char>,
    var closed: Boolean = false
) : LetterSupplier {

    override fun get(): Char {
        val letter = letters.poll()
        letters.offer(letter)
        return letter
    }

    override fun close() {
        closed = true
    }
}