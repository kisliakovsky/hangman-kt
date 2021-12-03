package org.kislyi.hangman

import java.io.Writer

interface Attempt {

    fun increment()

    fun exceeded(): Boolean

    fun write(writer: Writer)
}
