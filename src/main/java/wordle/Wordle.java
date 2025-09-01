package wordle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wordle {
    private final String secretWord;
    private final int attempts;

    public Wordle(String secretWord, int attempts) {
        this.secretWord = secretWord.toLowerCase();
        this.attempts = attempts;
    }

    public String play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to wordle! Guess the 5 letter secret word within " + attempts + " attempts and you win!");
        int guesses = attempts;
        for (int count = 0; count < attempts; count++) {
            int correctPositionCount = 0;
            int correctCharCount = 0;
            List<Character> correctLetters = new ArrayList<>();
            System.out.println("What is your guess?");
            String guess = scanner.nextLine();
            if (guess.isEmpty()) {
                System.out.println("Please guess a valid word!");
                continue;
            }
            if (guess.length() != 5) {
                System.out.println("The secret word is five letters. Try again!");
                continue;
            }
            if (guess.equals(this.secretWord)) {
                return "Congratulations! You found the secret word!";
            }
            for (int j = 0; j < this.secretWord.length(); j++) {
                char letter = guess.charAt(j);
                if (this.secretWord.contains(Character.toString(letter))) {
                    correctCharCount++;
                    correctLetters.add(letter);
                }
                if (guess.charAt(j) == this.secretWord.charAt(j)) {
                    correctPositionCount++;
                }
            }
            guesses--;
            if (correctPositionCount == 1) {
                System.out.println("You have guessed " + correctCharCount + " correct letter (Yellow)");
                System.out.println("The correct letter is " + correctLetters);
                System.out.println("You have guessed " + correctPositionCount + " letter in the right place. Try again! (Green)");
            } else {
                System.out.println("You have guessed " + correctCharCount + " correct letters (Yellow)");
                System.out.println("The correct letters are " + correctLetters);
                System.out.println("You have guessed " + correctPositionCount + " letters in the right place. Try again! (Green)");
            }
            System.out.println("Guesses remaining: " + guesses);
        }
        return "Better luck next time! The correct word was " + this.secretWord;
    }
}
