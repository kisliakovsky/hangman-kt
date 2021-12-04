package org.kislyi.hangman

import java.io.Writer

class FakeLetterRiddle(
    private val leftLetter: Char,
    private val guesses: MutableCollection<Char>,
    private val guessed: Boolean
) : LetterRiddle {
    override fun left(letter: Char) = leftLetter == letter

    override fun guess(letter: Char) {
        guesses.add(letter)
    }

    override fun guessed() = guessed

    override fun write(writer: Writer) {
        writer.write("fake")
    }
}
