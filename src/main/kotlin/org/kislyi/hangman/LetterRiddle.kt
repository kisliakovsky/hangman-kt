package org.kislyi.hangman

import java.io.Writer

interface LetterRiddle {

    fun left(letter: Char): Boolean

    fun guess(letter: Char)

    fun guessed(): Boolean

    fun write(writer: Writer)

}
