package org.kislyi.hangman

interface LetterGame {

    fun guess(letter: Char)

    fun finished() : Boolean

    fun won() : Boolean

}
