package org.kislyi.hangman

class HangmanGame(
    private val riddle: LetterRiddle,
    private val attempt: Attempt
) : LetterGame {

    override fun guess(letter: Char) {
        if (!riddle.left(letter))
            attempt.increment()
        riddle.guess(letter)
    }

    override fun finished(): Boolean {
        return riddle.guessed() || attempt.exceeded()
    }

    override fun won() = riddle.guessed() && !attempt.exceeded()
}
