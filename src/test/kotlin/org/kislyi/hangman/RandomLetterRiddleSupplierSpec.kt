package org.kislyi.hangman

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.util.*

class RandomLetterRiddleSupplierSpec : BehaviorSpec({

    Given("List of riddles") {
        val riddles = listOf(
            WordRiddle(EnglishWord("simplicity")),
            WordRiddle(EnglishWord("equality")),
            WordRiddle(EnglishWord("grandmother")),
            WordRiddle(EnglishWord("neighborhood")),
            WordRiddle(EnglishWord("relationship")),
            WordRiddle(EnglishWord("mathematics")),
            WordRiddle(EnglishWord("university")),
            WordRiddle(EnglishWord("explanation"))
        )

        And("Random") {
            val random = Random(47)

            And("Random letter riddle supplier") {
                val supplier = RandomLetterRiddleSupplier(riddles, random)

                When("Get the next value") {
                    val riddle = supplier.get()

                    Then("Riddle should be correct") {
                        riddle shouldBe WordRiddle(EnglishWord("mathematics"))
                    }
                }
            }
        }
    }
})
