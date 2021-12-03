package org.kislyi.hangman

import io.kotest.core.spec.IsolationMode.InstancePerLeaf
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.io.StringWriter

class IntAttemptSpec : BehaviorSpec({

    isolationMode = InstancePerLeaf

    val writer = StringWriter()

    afterTest {
        writer.buffer.setLength(0)
    }

    Given("Zero attempt") {
        val attempt = IntAttempt(0, 3)

        When("Increment attempt") {
            attempt.increment()

            Then("Next attempt should have incremented value") {
                attempt shouldBe IntAttempt(1, 3)
            }
        }

        When("Check if attempt is exceeded") {
            val exceeded = attempt.exceeded()

            Then("Attempt should not be exceeded") {
                exceeded shouldNotBe true
            }
        }

        When("Write attempt") {
            attempt.write(writer)

            Then("Writer string should contain attempt") {
                writer.toString() shouldBe "#0 out of 3"
            }
        }
    }

    Given("Third of three attempt") {
        val attempt = IntAttempt(3, 3)

        When("Check if attempt is exceeded") {
            val exceeded = attempt.exceeded()

            Then("Attempt should be exceeded") {
                exceeded shouldBe true
            }
        }

        When("Write attempt") {
            attempt.write(writer)

            Then("Writer string should contain attempt") {
                writer.toString() shouldBe "#3 out of 3"
            }
        }
    }
})
