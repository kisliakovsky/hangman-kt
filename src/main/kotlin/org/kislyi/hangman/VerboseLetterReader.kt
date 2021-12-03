package org.kislyi.hangman

import java.io.Writer

class VerboseLetterReader(
    private val letterReader: LetterReader,
    private val writer: Writer
) : LetterReader {

    override fun hasNext() = letterReader.hasNext()

    override fun next(): Char {
        writer.write("Guess a letter: ")
        return letterReader.next()
    }

    override fun close() {
        letterReader.close()
    }
}
