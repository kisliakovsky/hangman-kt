package org.kislyi.hangman

import java.util.*

class LetterScanner(private val scanner: Scanner) : LetterReader {

    override fun hasNext() = scanner.hasNext()

    override fun next() = scanner.next()[0]

    override fun close() {
        scanner.close()
    }
}
