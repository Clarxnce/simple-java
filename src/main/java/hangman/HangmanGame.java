package hangman;

public class HangmanGame {
    public static void main(String[] args) {
        Hangman hangman = new Hangman("NaaTeiko", 6);
        System.out.println(hangman.play());
    }
}
