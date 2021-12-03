package org.kislyi.hangman

import java.io.Writer

class IntAttempt(
    private var made: Int,
    private val max: Int
) : Attempt {

    constructor(max: Int) : this(0, max)

    override fun increment() {
        made++
    }

    override fun exceeded() = made >= max


    override fun write(writer: Writer) {
        writer.write("#$made out of $max")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as IntAttempt

        if (made != other.made) return false
        if (max != other.max) return false

        return true
    }

    override fun hashCode(): Int {
        var result = made
        result = 31 * result + max
        return result
    }
}
