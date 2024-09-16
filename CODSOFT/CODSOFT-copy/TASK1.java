import java.util.Scanner;
public class TASK1 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int maxAttempts = 5;
        int rounds = 0;
        int totalAttempts = 0;
        int roundsWon = 0;

        while (true) {
            rounds++;
            int randomNumber = (int) (Math.random() * 100) + 1;
            int attempts = 0;

            System.out.println("Round " + rounds);
            System.out.println("Guess a number between 1 and 100:");

            while (attempts < maxAttempts) {
                attempts++;
                int guess = sc.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    roundsWon++;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The number was: " + randomNumber);
                totalAttempts += maxAttempts;
            }

            System.out.println("Would you like to play another round? (yes/no)");
            String playAgain = sc.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Game over!");
        System.out.println("Rounds played: " + rounds);
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Average attempts per round: " + (double) totalAttempts / rounds);
    }
}