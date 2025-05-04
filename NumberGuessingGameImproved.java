import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGameImproved {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7; // You can adjust the number of attempts
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Improved Number Guessing Game!");

        while (playAgain) {
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int guess;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low! Try again. (" + (maxAttempts - attempts) + " attempts remaining)");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again. (" + (maxAttempts - attempts) + " attempts remaining)");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                    score++; // Increment score for a correct guess
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nYou ran out of attempts! The number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("\nThanks for playing! Your final score is: " + score);
        scanner.close();
    }
}
