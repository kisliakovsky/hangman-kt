package org.kislyi.hangman

class OneLetterSupplier(
    private val letter: Char,
) : LetterSupplier {

    var closed: Boolean = false

    override fun get() = letter

    override fun close() {
        closed = true
    }
}