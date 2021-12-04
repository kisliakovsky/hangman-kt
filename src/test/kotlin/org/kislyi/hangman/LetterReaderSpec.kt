package org.kislyi.hangman

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import java.util.*

class LetterReaderSpec : BehaviorSpec({

    Given("Scanner") {
        val scanner = mockk<Scanner> {
            coEvery {
                next()
            } returns "ok"
        }

        And("Letter reader") {
            val reader = LetterReader(scanner)

            When("Get the next value") {
                val next = reader.get()

                Then("Letter reader should return the first letter of the scanner's next value") {
                    next shouldBe 'o'
                }
            }
        }
    }
})
