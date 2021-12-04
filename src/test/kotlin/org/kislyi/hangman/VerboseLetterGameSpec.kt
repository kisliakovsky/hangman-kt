package org.kislyi.hangman

import io.kotest.core.spec.IsolationMode.InstancePerLeaf
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.io.StringWriter

class VerboseLetterGameSpec : BehaviorSpec({

    isolationMode = InstancePerLeaf

    val writer = StringWriter()
    val guesses = mutableSetOf<Char>()

    afterTest {
        writer.buffer.setLength(0)
        guesses.clear()
    }

    Given("Won letter game") {
        val game = FakeLetterGame(guesses, true, true)

        And("Verbose letter game") {
            val verboseGame = VerboseLetterGame(game, writer)

            When("Guess a letter") {
                verboseGame.guess('o')

                Then("Letter should be guessed in the inner game") {
                    guesses shouldContain 'o'
                }
            }

            When("Check if game is finished") {
                val finished = verboseGame.finished()

                Then("Game should be finished") {
                    finished shouldBe true
                }
            }

            When("Check if game is won") {
                val won = verboseGame.won()

                Then("Game should be won") {
                    won shouldBe true
                }

                And("Writer string should contain 'win' string") {
                    writer.toString() shouldBe "You won!\n"
                }
            }
        }
    }

    Given("Lost letter game") {
        val game = FakeLetterGame(guesses, true, false)

        And("Verbose letter game") {
            val verboseGame = VerboseLetterGame(game, writer)

            When("Guess a letter") {
                verboseGame.guess('o')

                Then("Letter should be guessed in the inner game") {
                    guesses shouldContain 'o'
                }
            }

            When("Check if game is finished") {
                val finished = verboseGame.finished()

                Then("Game should be finished") {
                    finished shouldBe true
                }
            }

            When("Check if game is won") {
                val won = verboseGame.won()

                Then("Game should not be won") {
                    won shouldNotBe true
                }

                And("Writer string should contain 'lose' string") {
                    writer.toString() shouldBe "You lost.\n"
                }
            }
        }
    }
})
