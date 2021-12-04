package org.kislyi.hangman

import java.util.*

class RandomLetterRiddleSupplier(
    private val riddles: List<LetterRiddle>,
    private val random: Random
) : LetterRiddleSupplier {

    init {
        require(riddles.isNotEmpty()) {
            "Riddle list must be not empty"
        }
    }

    override fun get() = riddles[random.nextInt(riddles.size)]
}
