package org.kislyi.hangman

import io.kotest.core.spec.IsolationMode.InstancePerLeaf
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.io.StringWriter
import java.util.*

class HangmanGameAppSpec : BehaviorSpec({

    isolationMode = InstancePerLeaf

    val writer = StringWriter()

    afterTest {
        writer.buffer.setLength(0)
    }

    Given("Riddle supplier") {
        val riddleSupplier = OneLetterRiddleSupplier(WordRiddle(EnglishWord("simplicity")))

        And("Attempt") {
            val attempt = IntAttempt(5)

            And("One letter supplier") {
                val letterSupplier = OneLetterSupplier('a')

                And("Hangman game app") {
                    val app = HangmanGameApp(riddleSupplier, letterSupplier, writer, attempt)

                    When("Run app") {
                        app.run()

                        Then("Writer string contains 'defeat' string") {
                            writer.toString() shouldBe "Guess a letter: Missed, mistake #1 out of 5\n" +
                                    "The word: ??????????\n\n" +
                                    "Guess a letter: Missed, mistake #2 out of 5\n" +
                                    "The word: ??????????\n\n" +
                                    "Guess a letter: Missed, mistake #3 out of 5\n" +
                                    "The word: ??????????\n\n" +
                                    "Guess a letter: Missed, mistake #4 out of 5\n" +
                                    "The word: ??????????\n\n" +
                                    "Guess a letter: Missed, mistake #5 out of 5\n" +
                                    "The word: ??????????\n\n" +
                                    "You lost.\n"
                        }
                    }
                }
            }

            And("Riddle word letter supplier") {
                val letterSupplier = CycleLetterSupplier(
                    ArrayDeque(listOf('s', 'i', 'm', 'p', 'l', 'c', 't', 'y'))
                )

                And("Hangman game app") {
                    val app = HangmanGameApp(riddleSupplier, letterSupplier, writer, attempt)

                    When("Run app") {
                        app.run()

                        Then("Writer string contains 'win' string") {
                            writer.toString() shouldBe "Guess a letter: Hit!\n" +
                                    "The word: s?????????\n\n" +
                                    "Guess a letter: Hit!\n" +
                                    "The word: si???i?i??\n\n" +
                                    "Guess a letter: Hit!\n" +
                                    "The word: sim??i?i??\n\n" +
                                    "Guess a letter: Hit!\n" +
                                    "The word: simp?i?i??\n\n" +
                                    "Guess a letter: Hit!\n" +
                                    "The word: simpli?i??\n\n" +
                                    "Guess a letter: Hit!\n" +
                                    "The word: simplici??\n\n" +
                                    "Guess a letter: Hit!\n" +
                                    "The word: simplicit?\n\n" +
                                    "Guess a letter: Hit!\n" +
                                    "The word: simplicity\n\n" +
                                    "You won!\n"
                        }
                    }
                }
            }
        }
    }
})
