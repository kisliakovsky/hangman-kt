package org.kislyi.hangman

class LetterGameApp(
    private val game: LetterGame,
    private val reader: LetterReader
) : App {

    override fun run() {
        while (!game.finished()) {
            game.guess(reader.next())
        }
        game.won()
    }
}
