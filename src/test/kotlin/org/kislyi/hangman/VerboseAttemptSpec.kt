package org.kislyi.hangman

import io.kotest.core.spec.IsolationMode.InstancePerLeaf
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldBeEmpty
import java.io.StringWriter

class VerboseAttemptSpec : BehaviorSpec({

    isolationMode = InstancePerLeaf

    val writer = StringWriter()

    afterTest {
        writer.buffer.setLength(0)
    }

    Given("Attempt") {
        val attempt = IntAttempt(2, 3)

        And("Verbose attempt") {
            val verboseAttempt = VerboseAttempt(attempt, writer)

            When("Check if attempt is exceeded") {
                val exceeded = verboseAttempt.exceeded()

                Then("Attempt should not be exceeded") {
                    exceeded shouldNotBe true
                }

                And("Writer should be empty") {
                    writer.toString().shouldBeEmpty()
                }
            }

            When("Increment") {
                verboseAttempt.increment()

                Then("Attempt should be incremented") {
                    attempt shouldBe IntAttempt(3, 3)
                }

                And("Writer should contain attempt string") {
                    writer.toString() shouldBe "Missed, mistake #3 out of 3\n"
                }
            }

            When("Write attempt") {
                verboseAttempt.write(writer)

                Then("Writer string should contain attempt") {
                    writer.toString() shouldBe "#2 out of 3"
                }
            }
        }
    }
})
