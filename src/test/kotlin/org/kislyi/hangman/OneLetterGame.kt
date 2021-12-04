package org.kislyi.hangman

class OneLetterGame(
    private val guesses: MutableCollection<Char>
) : LetterGame {

    override fun guess(letter: Char) {
        guesses.add(letter)
    }

    override fun finished() = guesses.isNotEmpty()

    override fun won() = guesses.isNotEmpty()
}
