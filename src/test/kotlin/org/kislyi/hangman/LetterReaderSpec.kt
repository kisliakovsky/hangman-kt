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
                nextLine()
            } returns "Ok"
        }

        And("Letter reader") {
            val reader = LetterReader(scanner)

            When("Get the next value") {
                val next = reader.get()

                Then("Reader should return the first letter of the scanner's next value in the lower case") {
                    next shouldBe 'o'
                }
            }
        }
    }
})
