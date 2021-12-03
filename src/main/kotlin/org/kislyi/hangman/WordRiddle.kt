package org.kislyi.hangman

import java.io.Writer

class WordRiddle(
    private val word: Word,
    private val guessedLetters: MutableCollection<Char>
) : LetterRiddle {

    constructor(word: Word) : this(word, mutableSetOf())

    override fun left(letter: Char) = letter !in guessedLetters && letter in word

    override fun guess(letter: Char) {
        word.forEach {
            if (it == letter) {
                guessedLetters.add(letter)
            }
        }
    }

    override fun guessed() = guessedLetters.size == word.length

    override fun write(writer: Writer) {
        writer.write(
            word.map { if (it in guessedLetters) it else '?' }
                .joinToString("")
        )
    }
}
