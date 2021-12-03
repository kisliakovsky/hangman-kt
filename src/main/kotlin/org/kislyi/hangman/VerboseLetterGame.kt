package org.kislyi.hangman

import java.io.Writer

class VerboseLetterGame(
    private val letterGame: LetterGame,
    private val writer: Writer
) : LetterGame {

    override fun guess(letter: Char) {
        letterGame.guess(letter)
    }

    override fun finished() = letterGame.finished()

    override fun won(): Boolean {
        val won = letterGame.won()
        if (won) writer.write("You won!") else writer.write("You lost.")
        writer.write("\n")
        return won
    }
}
