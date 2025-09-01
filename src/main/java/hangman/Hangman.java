package hangman;

import java.util.HashSet;
import java.util.Scanner;

public class Hangman {
    private final String secretWord;
    private final int attempts;
    private StringBuilder guessedWord;
    private HashSet<Character> guessedLetters;

    public Hangman (String secretWord, int attempts) {
        this.secretWord = secretWord;
        this.attempts = attempts;
        this.guessedWord = new StringBuilder().append("_".repeat(secretWord.length()));
        this.guessedLetters = new HashSet<>();
    }

    public String play() {
        String answer = secretWord.toLowerCase();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to hangman! You have " + attempts + " attempts to figure out the hidden word!");
        System.out.println("The hidden word has " + secretWord.length() + " letters: " + guessedWord);
        int guesses = attempts;
        while (guesses > 0) {
            System.out.println("What is your guess?");
            String guess = scanner.nextLine();
            char charGuess = guess.charAt(0);
            if (guessedLetters.contains(charGuess)) {
                System.out.println("You have already guessed " + guess + "! Try again.");
                continue;
            }
            if (answer.contains(guess)) {
                for (int index = 0; index < answer.length(); index++) {
                    if (charGuess == answer.charAt(index)) {
                        this.guessedWord.replace(index, index + 1, guess);
                    }
                }
                guessedLetters.add(charGuess);
                System.out.println("Correct! " + guess + " is in the hidden word");
                if (guessedWord.toString().equals(answer)) {
                    return "Congratulations! You found the hidden word: " + secretWord;
                }
                System.out.println("Guessed word: " + guessedWord);
                System.out.println("Guessed letters: " + guessedLetters);
            } else {
                guessedLetters.add(charGuess);
                guesses--;
                System.out.println("Incorrect! You have " + guesses + " guesses left.");
                System.out.println("Guessed letters: " + guessedLetters);
                HangmanUI.draw(guesses);
            }
        }
        return "Game over! The hidden word was " + secretWord + ".";
    }
}

