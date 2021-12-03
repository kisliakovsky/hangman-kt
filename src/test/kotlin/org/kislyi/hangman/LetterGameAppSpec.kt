package org.kislyi.hangman

import io.kotest.core.spec.IsolationMode.InstancePerLeaf
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import java.util.ArrayDeque

class LetterGameAppSpec : BehaviorSpec({

    isolationMode = InstancePerLeaf

    val guesses = mutableSetOf<Char>()

    afterTest {
        guesses.clear()
    }

    Given("Letter game") {
        val game = OneLetterGame(guesses)

        And("Letter reader") {
            val letter = 'o'
            val lettersDeque = ArrayDeque(listOf(letter))
            val reader = DequeLetterReader(lettersDeque)

            And("Letter game app") {
                val app = LetterGameApp(game, reader)

                When("Run app") {
                    app.run()

                    Then("Game should be finished") {
                        game.finished() shouldBe true
                    }

                    And("Game should be won") {
                        game.won() shouldBe true
                    }

                    And("Guesses should contain 'o' letter") {
                        guesses shouldContain letter
                    }

                    And("Letters deque should be empty") {
                        lettersDeque.shouldBeEmpty()
                    }
                }
            }
        }
    }
})
