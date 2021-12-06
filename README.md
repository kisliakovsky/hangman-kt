# Hangman Game

[Hangman](https://en.wikipedia.org/wiki/Hangman_%28game%29) is a words
guessing game for one player. The computer guesses a word and the user
has to suggest letters one by one. Every time the word contains a letter,
the computer opens it (all of them, if there are a few). Every time the
word doesn't contain a letter, the computer gives a penalty point for
the user. If there are five penalty points, the user loses. If there
are no hidden letters anymore, the computer loses.  
  
This is a refactored Kotlin version of the game presented by [@yegor256](https://github.com/yegor256/hangman) [here](https://github.com/yegor256/hangman).  
  
## Prerequisitions
Make sure you have Java installed. To install Java you can use [SDKMAN!](https://sdkman.io/)
  
## How to play  
Build the project by running:  
```
$ ./gradlew clean build
```
And then run:
```
$ java -jar ./build/libs/hangman-kt-1.0-SNAPSHOT-all.jar
```
Enjoy!
