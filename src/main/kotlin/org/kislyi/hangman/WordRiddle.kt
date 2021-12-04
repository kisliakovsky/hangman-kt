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

    override fun guessed() = word.all { it in guessedLetters }

    override fun write(writer: Writer) {
        writer.write(
            word.map { if (it in guessedLetters) it else '?' }
                .joinToString("")
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WordRiddle

        if (word != other.word) return false
        if (guessedLetters != other.guessedLetters) return false

        return true
    }

    override fun hashCode(): Int {
        var result = word.hashCode()
        result = 31 * result + guessedLetters.hashCode()
        return result
    }
}
