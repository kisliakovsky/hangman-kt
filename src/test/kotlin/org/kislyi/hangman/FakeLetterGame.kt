package org.kislyi.hangman

class FakeLetterGame(
    private val guesses: MutableCollection<Char>,
    private val finished: Boolean,
    private val won: Boolean
) : LetterGame {
    override fun guess(letter: Char) {
        guesses.add(letter)
    }

    override fun finished() = finished

    override fun won() = won
}
