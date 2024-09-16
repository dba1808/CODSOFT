import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private static final int NUM_QUESTIONS = 8;
    private static final int TIMER_SECONDS = 10;
    private static final String[] questions = {
            "What is the capital of France?",
            "Who painted the Mona Lisa?",
            "Who was the first person to set foot on the moon?",
            "In which sport is the term 'love' used to represent a score of zero?",
            "What is the chemical symbol for gold?",
            "What is a linear data structure where elements can be added or removed from either end?",
            "What is a sequence of instructions executed by a computer?",
            "What is a block of code that performs a specific task?"};
    private static final String[] answers = {
            "Paris",
            "Leonardo da Vinci",
            "Neil Armstrong",
            "Tennis",
            "Au",
            "Deque",
            "Program",
            "Function" };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUM_QUESTIONS; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up!");
                    timer.cancel();
                }
            }, TIMER_SECONDS * 1000);

            String userAnswer = sc.nextLine();
            if (userAnswer.equalsIgnoreCase(answers[i])) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is: " + answers[i]);
            }

            timer.cancel();
        }

        long endTime = System.currentTimeMillis();
        long totalTime = (endTime - startTime) / 1000;
        double percentage = (double) score / NUM_QUESTIONS * 100;

        System.out.println("\nQuiz completed!");
        System.out.println("Total time taken: " + totalTime + " seconds");
        System.out.println("Score: " + score + "/" + NUM_QUESTIONS);
        System.out.println("Percentage: " + percentage + "%");
    }
}