package org.kislyi.hangman

class HangmanGame(
    private val riddle: LetterRiddle,
    private val attempt: Attempt
) : LetterGame {

    override fun guess(letter: Char) {
        if (riddle.left(letter)) riddle.guess(letter) else attempt.increment()
    }

    override fun finished() = riddle.guessed() || attempt.exceeded()

    override fun won() = riddle.guessed() && !attempt.exceeded()
}
