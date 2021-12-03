package org.kislyi.hangman

import java.io.Writer

class VerboseLetterRiddle(
    private val riddle: LetterRiddle,
    private val writer: Writer
) : LetterRiddle {

    override fun left(letter: Char) = riddle.left(letter)

    override fun guess(letter: Char) {
        if (riddle.left(letter)) writer.write("Hit!\n")
        riddle.guess(letter)
        writer.write("The word: ")
        riddle.write(writer)
        writer.write("\n\n")
    }

    override fun guessed() = riddle.guessed()

    override fun write(writer: Writer) {
        riddle.write(writer)
    }
}
