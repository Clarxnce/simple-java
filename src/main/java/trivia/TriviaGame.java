package trivia;

import java.util.Scanner;

public class TriviaGame {
    public static void main(String[] args) {
        Question question1 = new Question("What is 1 + 1?", new String[]{"1. 1", "2. 2", "3. 3", "4. 4"}, 2);
        Question question2 = new Question("What is 2 + 2?", new String[]{"1. 2", "2. 4", "3. 6", "4. 8"}, 2);
        Question question3 = new Question("What is 3 + 3?", new String[]{"1. 3", "2. 6", "3. 9", "4. 12"}, 2);
        Question question4 = new Question("What is 4 + 4?", new String[]{"1. 2", "2. 4", "3. 6", "4. 8"}, 4);
        Question question5 = new Question("What is 5 + 5?", new String[]{"1. 4", "2. 6", "3. 10", "4. 25"}, 3);
        Question question6 = new Question("What is the most abundant liquid on Earth?",
                new String[]{"1. Coca Cola", "2. Apple Juice", "3. Water", "4. Beer"}, 3);
        Question[] questions = {
                question1,
                question2,
                question3,
                question4,
                question5,
                question6
        };

        play(questions);
    }

    public static void play(Question[] questions) {
        int score = 0;
        int correctCount = 0;
        int questionCount = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the trivia game! Test your trivia knowledge by answering 5 of the hardest " +
                "questions known to man, and see how many points you can score!");
        System.out.println("Are you ready? Let's begin");
        for (Question question : questions) {
            System.out.println(questionCount + ". " + question.getQuestion());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }
            int guess;

            while (true) {
                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();

                    if (guess >= 1 && guess <= 4) {
                        break; //valid input, exit input loop
                    } else {
                        System.out.println("Choose from one of the four options!");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number");
                    scanner.next(); //clear invalid input
                }
            }
            if (question.isCorrectAnswer(guess)) {
                System.out.println("Correct!");
                score += 10;
                correctCount += 1;
            } else {
                System.out.println("Close one! The correct option was: " + question.getCorrectAnswer());
            }
            questionCount++;
            if (questionCount <= questions.length - 1) {
                System.out.println("Here comes the next question:");
            }
        }
        System.out.println("Game over! You answered " + correctCount + " questions correctly and finished the game" +
                " with a total score of " + score + " points!");
    }
}
