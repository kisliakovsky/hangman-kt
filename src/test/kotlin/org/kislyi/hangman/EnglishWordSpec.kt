package org.kislyi.hangman

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class EnglishWordSpec : BehaviorSpec({

    Given("Raw foreign word") {
        val word = "слово"

        When("Wrap with EnglishWord") {
            val attempt = { EnglishWord(word) }

            Then("Failed to wrap") {
                val exception = shouldThrow<IllegalArgumentException> {
                    attempt()
                }
                exception.message shouldBe "Characters must be small English letters"
            }
        }
    }

    Given("English word") {
        val string = "word"
        val word = EnglishWord(string)

        When("Get letter from the word") {
            val letter = word[0]

            Then("Letter should be correct") {
                letter shouldBe 'w'
            }
        }

        When("Make subsequence") {
            val subsequence = word.subSequence(0, 2)

            Then("Subsequence should be correct") {
                subsequence shouldBe "wo"
            }
        }

        When("Get length") {
            val length = word.length

            Then("Length should be correct") {
                length shouldBe 4
            }
        }
    }
})
