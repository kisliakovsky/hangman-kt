package org.kislyi.hangman

class OneLetterRiddleSupplier(private val riddle: LetterRiddle) : LetterRiddleSupplier {
    override fun get() = riddle
}
