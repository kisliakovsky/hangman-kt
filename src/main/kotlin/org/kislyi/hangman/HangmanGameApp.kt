package org.kislyi.hangman

import java.io.Writer

class HangmanGameApp(
    riddleSupplier: LetterRiddleSupplier,
    letterSupplier: LetterSupplier,
    writer: Writer
) : LetterGameApp(
    VerboseLetterGame(
        HangmanGame(
            VerboseLetterRiddle(riddleSupplier.get(), writer),
            VerboseAttempt(
                IntAttempt(0, 5),
                writer
            )
        ),
        writer
    ),
    VerboseLetterSupplier(
        letterSupplier,
        writer
    )
)
