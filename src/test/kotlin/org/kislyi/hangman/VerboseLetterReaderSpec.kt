package org.kislyi.hangman

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.io.StringWriter

class VerboseLetterReaderSpec : BehaviorSpec({

    isolationMode = IsolationMode.InstancePerLeaf

    val writer = StringWriter()

    afterTest {
        writer.buffer.setLength(0)
    }

    Given("Letter reader") {
        val letter = 'o'
        val reader = LetterReader.Fake(letter)

        And("Verbose letter reader") {
            val verboseReader = VerboseLetterReader(reader, writer)

            When("Check if reader has the next value") {
                val hasNext = verboseReader.hasNext()

                Then("Reader should have the next value") {
                    hasNext shouldBe true
                }
            }

            When("Close reader") {
                verboseReader.close()

                Then("The inner reader should be closed") {
                    reader.closed shouldBe true
                }
            }

            When("Get the reader's next value") {
                val next = verboseReader.next()

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
