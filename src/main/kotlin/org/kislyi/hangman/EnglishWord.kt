package org.kislyi.hangman

class EnglishWord(private val value: String) : Word {

    init {
        for (c in value) {
            require(c in 'a'..'z') {
                "Characters must be small English letters"
            }
        }
    }

    override fun get(index: Int) = value[index]

    override fun subSequence(startIndex: Int, endIndex: Int) = value.subSequence(startIndex, endIndex)

    override val length = value.length

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EnglishWord

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
