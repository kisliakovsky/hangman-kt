package org.kislyi.hangman

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import java.util.*

class LetterScannerSpec : BehaviorSpec({

    Given("Scanner") {
        val scanner = mockk<Scanner> {
            coEvery {
                hasNext()
            } returns true
            coEvery {
                next()
            } returns "ok"
        }

        And("Char scanner") {
            val letterScanner = LetterScanner(scanner)

            When("Check if scanner has the next value") {
                val hasNext = letterScanner.hasNext()

                Then("Char scanner should have the next value") {
                    hasNext shouldBe true
                }
            }

            When("Get the next value") {
                val next = letterScanner.next()

                Then("Char scanner should return the first char of the scanner's next value") {
                    next shouldBe 'o'
                }
            }
        }
    }
})
