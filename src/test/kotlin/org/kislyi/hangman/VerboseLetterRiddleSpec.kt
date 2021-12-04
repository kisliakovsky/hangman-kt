package org.kislyi.hangman

import io.kotest.core.spec.IsolationMode.InstancePerLeaf
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.io.StringWriter

class VerboseLetterRiddleSpec : BehaviorSpec({

    isolationMode = InstancePerLeaf

    val writer = StringWriter()
    val guesses = mutableSetOf<Char>()

    afterTest {
        writer.buffer.setLength(0)
        guesses.clear()
    }

    Given("Letter riddle") {
        val letter = 'o'
        val riddle = FakeLetterRiddle(letter, guesses, false)

        And("Verbose letter riddle") {
            val verboseLetterRiddle = VerboseLetterRiddle(riddle, writer)

            When("Check if letter is left") {
                val left = verboseLetterRiddle.left(letter)

                Then("Letter should be left") {
                    left shouldBe true
                }
            }

            When("Check if riddle is guessed") {
                val guessed = verboseLetterRiddle.guessed()

                Then("Riddle should not be guessed") {
                    guessed shouldNotBe true
                }
            }

            When("Guess a letter") {
                verboseLetterRiddle.guess(letter)

                Then("Letter of the inner riddle should be guessed") {
                    guesses shouldContain letter
                }

                And("Writer string contains the 'hit' string and a the riddle string") {
                    writer.toString() shouldBe "Hit!\nThe word: fake\n\n"
                }
            }

            And("Another letter") {
                val anotherLetter = 'a'

                When("Guess a letter") {
                    verboseLetterRiddle.guess(anotherLetter)

                    Then("Letter should be checked by the riddle") {
                        guesses shouldContain anotherLetter
                    }

                    And("Writer string should contain the riddle sting") {
                        writer.toString() shouldBe "The word: fake\n\n"
                    }
                }
            }

            When("Write riddle") {
                verboseLetterRiddle.write(writer)

                Then("Writer string should contain 'fake' string") {
                    writer.toString() shouldBe "fake"
                }
            }
        }
    }
})
