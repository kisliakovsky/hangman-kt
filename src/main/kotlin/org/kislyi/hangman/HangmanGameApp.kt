package org.kislyi.hangman

import java.io.OutputStreamWriter
import java.io.PrintStream
import java.io.Writer
import java.util.*

class HangmanGameApp(
    riddleSupplier: LetterRiddleSupplier,
    letterSupplier: LetterSupplier,
    writer: Writer,
    attempt: Attempt
) : LetterGameApp(
    VerboseLetterGame(
        HangmanGame(
            VerboseLetterRiddle(riddleSupplier.get(), writer),
            VerboseAttempt(attempt, writer)
        ),
        writer
    ),
    VerboseLetterSupplier(letterSupplier, writer)
)

fun main() {
    OutputStreamWriter(PrintStream(System.out)).use { writer ->
        LetterReader(Scanner(System.`in`)).use { reader ->
            HangmanGameApp(
                RandomLetterRiddleSupplier(
                    listOf(
                        WordRiddle(EnglishWord("simplicity")),
                        WordRiddle(EnglishWord("equality")),
                        WordRiddle(EnglishWord("grandmother")),
                        WordRiddle(EnglishWord("neighborhood")),
                        WordRiddle(EnglishWord("relationship")),
                        WordRiddle(EnglishWord("mathematics")),
                        WordRiddle(EnglishWord("university")),
                        WordRiddle(EnglishWord("explanation"))
                    ),
                    Random()
                ),
                reader,
                writer,
                IntAttempt(max = 5)
            ).run()
        }
    }
}
