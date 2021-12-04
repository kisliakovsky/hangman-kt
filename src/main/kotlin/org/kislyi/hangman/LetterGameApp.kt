package org.kislyi.hangman

open class LetterGameApp(
    private val game: LetterGame,
    private val letterSupplier: LetterSupplier
) : App {

    override fun run() {
        while (!game.finished()) {
            game.guess(letterSupplier.get())
        }
        game.won()
    }
}
