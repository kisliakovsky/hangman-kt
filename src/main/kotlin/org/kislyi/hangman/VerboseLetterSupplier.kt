package org.kislyi.hangman

import java.io.Writer

class VerboseLetterSupplier(
    private val letterSupplier: LetterSupplier,
    private val writer: Writer
) : LetterSupplier {

    override fun get(): Char {
        writer.write("Guess a letter: ")
        writer.flush()
        return letterSupplier.get()
    }

    override fun close() {
        letterSupplier.close()
    }
}
