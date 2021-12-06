package org.kislyi.hangman

import io.kotest.core.spec.IsolationMode.InstancePerLeaf
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.io.StringWriter

class WordRiddleSpec : BehaviorSpec({

    isolationMode = InstancePerLeaf

    val writer = StringWriter()

    afterTest {
        writer.buffer.setLength(0)
    }

    Given("Word") {
        val word = EnglishWord("simplicity")

        And("Empty guessed letters collection") {
            val guessedLetters = mutableSetOf<Char>()

            And("Word riddle") {
                val riddle = WordRiddle(word, guessedLetters)

                When("Check if riddle is guessed") {
                    val guessed = riddle.guessed()

                    Then("Riddle should not be guessed") {
                        guessed shouldNotBe true
                    }
                }

                And("Letter from the word") {
                    val letter = 'i'

                    When("Check if $letter is left") {
                        val left = riddle.left(letter)

                        Then("The riddle should have $letter left") {
                            left shouldBe true
                        }
                    }

                    When("Guess lower case ${letter.lowercaseChar()}") {
                        riddle.guess(letter)

                        Then("Guessed letters should contain $letter") {
                            guessedLetters shouldContain letter.lowercaseChar()
                        }
                    }

                    When("Guess upper case ${letter.uppercaseChar()}") {
                        riddle.guess(letter)

                        Then("Guessed letters should contain $letter") {
                            guessedLetters shouldContain letter.lowercaseChar()
                        }
                    }
                }

                And("Another letter") {
                    val letter = 'a'

                    When("Check if $letter is left") {
                        val left = riddle.left(letter)

                        Then("The riddle should not have $letter left") {
                            left shouldNotBe true
                        }
                    }

                    When("Guess $letter") {
                        riddle.guess(letter)

                        Then("$letter should not be guessed") {
                            guessedLetters.shouldBeEmpty()
                        }
                    }
                }

                When("Write riddle") {
                    riddle.write(writer)

                    Then("Writer string should contain masked word") {
                        writer.toString() shouldBe "??????????"
                    }
                }
            }
        }

        And("All letters from the word collection") {
            val guessedLetters = mutableSetOf('s', 'i', 'm', 'p', 'l', 'c', 't', 'y')

            And("Word riddle") {
                val riddle = WordRiddle(word, guessedLetters)

                When("Check if the riddle is guessed") {
                    val guessed = riddle.guessed()

                    Then("Riddle should be guessed") {
                        guessed shouldBe true
                    }
                }

                And("Letter from the word") {
                    val letter = 'o'

                    When("Check if $letter is left") {
                        val left = riddle.left(letter)

                        Then("The riddle should not have $letter left") {
                            left shouldBe false
                        }
                    }
                }

                When("Write riddle") {
                    riddle.write(writer)

                    Then("Writer string should contain unmasked word") {
                        writer.toString() shouldBe "simplicity"
                    }
                }
            }
        }
    }
})
