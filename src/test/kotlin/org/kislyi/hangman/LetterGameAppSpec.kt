package org.kislyi.hangman

import io.kotest.core.spec.IsolationMode.InstancePerLeaf
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

class LetterGameAppSpec : BehaviorSpec({

    isolationMode = InstancePerLeaf

    val guesses = mutableSetOf<Char>()

    afterTest {
        guesses.clear()
    }

    Given("Letter game") {
        val game = OneLetterGame(guesses)

        And("Letter supplier") {
            val letter = 'o'
            val letterSupplier = OneLetterSupplier('o')

            And("Letter game app") {
                val app = LetterGameApp(game, letterSupplier)

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
                }
            }
        }
    }
})
