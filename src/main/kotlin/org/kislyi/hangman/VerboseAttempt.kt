package org.kislyi.hangman

import java.io.Writer

class VerboseAttempt(
    private val attempt: Attempt,
    private val writer: Writer
) : Attempt {

    override fun increment() {
        attempt.increment()
        writer.write("Missed, mistake ")
        attempt.write(writer)
        writer.write("\n")
    }

    override fun exceeded() = attempt.exceeded()

    override fun write(writer: Writer) {
        attempt.write(writer)
    }
}
