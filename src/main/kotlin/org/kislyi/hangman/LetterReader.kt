package org.kislyi.hangman

import java.util.Scanner

class LetterReader(private val scanner: Scanner) : LetterSupplier {

    override fun get() = scanner.nextLine()[0].lowercaseChar()

    override fun close() {
        scanner.close()
    }
}
