package org.kislyi.hangman

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.io.StringWriter

class HangmanGameSpec : BehaviorSpec({

    val writer = StringWriter()
    val guesses = mutableSetOf<Char>()

    afterTest {
        writer.buffer.setLength(0)
        guesses.clear()
    }

    Given("Guessed letter riddle") {
        val letter = 'o'
        val riddle = LetterRiddle.Fake(letter, guesses, true)

        And("First attempt") {
            val attempt = IntAttempt(0, 3)

            And("Game") {
                val game = HangmanGame(riddle, attempt)

                When("Check if the game is won") {
                    val won = game.won()

                    Then("Game should be won") {
                        won shouldBe true
                    }
                }

                When("Check if the game is finished") {
                    val finished = game.finished()

                    Then("Game should be finished") {
                        finished shouldBe true
                    }
                }

                When("Guess a letter") {
                    game.guess(letter)

                    Then("Letter should be guessed by the inner riddle") {
                        guesses shouldContain letter
                    }
                }

                And("Another letter") {
                    val anotherLetter = 'a'

                    When("Guess a letter") {
                        game.guess(anotherLetter)

                        Then("Letter should not be guessed by the inner riddle") {
                            guesses shouldNotContain anotherLetter
                        }
                    }
                }
            }
        }

        And("Exceeded attempt") {
            val attempt = IntAttempt(3, 3)

            And("Game") {
                val game = HangmanGame(riddle, attempt)

                When("Check if the game is won") {
                    val won = game.won()

                    Then("Game should not be won") {
                        won shouldBe false
                    }
                }

                When("Check if the game is finished") {
                    val finished = game.finished()

                    Then("Game should be finished") {
                        finished shouldBe true
                    }
                }

                When("Guess a letter") {
                    game.guess(letter)

                    Then("Letter should be guessed by the inner riddle") {
                        guesses shouldContain letter
                    }
                }

                And("Another letter") {
                    val anotherLetter = 'a'

                    When("Guess a letter") {
                        game.guess(anotherLetter)

                        Then("Letter should not be guessed by the inner riddle") {
                            guesses shouldNotContain anotherLetter
                        }
                    }
                }
            }
        }
    }

    Given("Not guessed letter riddle") {
        val letter = 'o'
        val riddle = LetterRiddle.Fake(letter, guesses, false)

        And("First attempt") {
            val attempt = IntAttempt(0, 3)

            And("Game") {
                val game = HangmanGame(riddle, attempt)

                When("Check if the game is won") {
                    val won = game.won()

                    Then("Game should not be won") {
                        won shouldNotBe true
                    }
                }

                When("Check if the game is finished") {
                    val finished = game.finished()

                    Then("Game should not be finished") {
                        finished shouldNotBe true
                    }
                }

                When("Guess a letter") {
                    game.guess(letter)

                    Then("Letter should be guessed by the inner riddle") {
                        guesses shouldContain letter
                    }
                }

                And("Another letter") {
                    val anotherLetter = 'a'

                    When("Guess a letter") {
                        game.guess(anotherLetter)

                        Then("Letter should not be guessed by the inner riddle") {
                            guesses shouldNotContain anotherLetter
                        }
                    }
                }
            }
        }

        And("Exceeded attempt") {
            val attempt = IntAttempt(3, 3)

            And("Game") {
                val game = HangmanGame(riddle, attempt)

                When("Check if the game is won") {
                    val won = game.won()

                    Then("Game should not be won") {
                        won shouldBe false
                    }
                }

                When("Check if the game is finished") {
                    val finished = game.finished()

                    Then("Game should be finished") {
                        finished shouldBe true
                    }
                }

                When("Guess a letter") {
                    game.guess(letter)

                    Then("Letter should be guessed by the inner riddle") {
                        guesses shouldContain letter
                    }
                }

                And("Another letter") {
                    val anotherLetter = 'a'

                    When("Guess a letter") {
                        game.guess(anotherLetter)

                        Then("Letter should not be guessed by the inner riddle") {
                            guesses shouldNotContain anotherLetter
                        }
                    }
                }
            }
        }
    }
})
