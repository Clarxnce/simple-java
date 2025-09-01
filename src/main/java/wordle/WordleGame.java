package wordle;

public class WordleGame {
    public static void main(String[] args) {
        Wordle wordle = new Wordle("Example", 6);
        System.out.println(wordle.play());
    }
}
