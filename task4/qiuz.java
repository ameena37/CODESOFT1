import java.util.*;

public class QuizGame {
    private static final int QUESTION_COUNT = 3;
    private static final int TIME_LIMIT_PER_QUESTION = 10; // Time limit per question in seconds
    private static final String[] QUESTIONS = {
        "What is the capital of France?",
        "What is the largest planet in our solar system?",
        "Who wrote 'To Kill a Mockingbird'?"
    };
    private static final String[][] OPTIONS = {
        {"A. London", "B. Paris", "C. Rome", "D. Madrid"},
        {"A. Jupiter", "B. Saturn", "C. Mars", "D. Earth"},
        {"A. J.K. Rowling", "B. Harper Lee", "C. Stephen King", "D. Charles Dickens"}
    };
    private static final char[] ANSWERS = {'B', 'A', 'B'}; // Correct answers
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;

        System.out.println("Welcome to the Quiz Game!");

        for (int i = 0; i < QUESTION_COUNT; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + QUESTIONS[i]);
            for (String option : OPTIONS[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (A/B/C/D): ");
            long startTime = System.currentTimeMillis();
            String answer = scanner.next().toUpperCase();
            long endTime = System.currentTimeMillis();
            long timeTaken = (endTime - startTime) / 1000;

            if (answer.charAt(0) == ANSWERS[i] && timeTaken <= TIME_LIMIT_PER_QUESTION) {
                System.out.println("Correct!");
                score++;
            } else if (timeTaken > TIME_LIMIT_PER_QUESTION) {
                System.out.println("Time's up! The correct answer was: " + OPTIONS[i][ANSWERS[i] - 'A']);
            } else {
                System.out.println("Incorrect! The correct answer was: " + OPTIONS[i][ANSWERS[i] - 'A']);
            }

            // Pause before moving to the next question
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nQuiz completed!");
        System.out.println("Your final score: " + score + "/" + QUESTION_COUNT);

        scanner.close();
    }
}