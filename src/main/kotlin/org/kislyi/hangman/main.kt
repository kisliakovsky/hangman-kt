package org.kislyi.hangman

import java.io.OutputStreamWriter
import java.io.PrintStream
import java.util.*

fun main() {
    val letterReader = LetterReader(Scanner(System.`in`))
    val writer = OutputStreamWriter(PrintStream(System.out))
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
        letterReader,
        writer
    ).run()
    writer.close()
    letterReader.close()
}
