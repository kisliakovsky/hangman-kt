package org.kislyi.hangman

import io.kotest.core.spec.IsolationMode.InstancePerLeaf
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.io.StringWriter

class VerboseLetterSupplierSpec : BehaviorSpec({

    isolationMode = InstancePerLeaf

    val writer = StringWriter()

    afterTest {
        writer.buffer.setLength(0)
    }

    Given("Letter supplier") {
        val letter = 'o'
        val supplier = OneLetterSupplier(letter)

        And("Verbose letter supplier") {
            val verboseSupplier = VerboseLetterSupplier(supplier, writer)

            When("Close supplier") {
                verboseSupplier.close()

                Then("The inner supplier should be closed") {
                    supplier.closed shouldBe true
                }
            }

            When("Get the supplier's next value") {
                val next = verboseSupplier.get()

                Then("The next value should be the letter") {
                    next shouldBe letter
                }

                And("Writer string should contain 'prompt' string") {
                    writer.toString() shouldBe "Guess a letter: "
                }
            }
        }
    }
})
