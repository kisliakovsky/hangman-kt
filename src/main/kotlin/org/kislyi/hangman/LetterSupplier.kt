package org.kislyi.hangman

import java.util.function.Supplier

interface LetterSupplier : Supplier<Char>, AutoCloseable
