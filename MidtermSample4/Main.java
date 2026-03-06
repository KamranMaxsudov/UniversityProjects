package MidtermSample4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create a GuessGame with 5 attempts (default range 1..100)
        GuessGame game = new GuessGame(5);

        System.out.println("Welcome to GuessGame!");
        System.out.println("You have " + game.getMaxAttempts() + " attempts to guess a number between "
                + game.getMin() + " and " + game.getMax() + ".");

        Scanner scanner = new Scanner(System.in);

        // Game loop: accept guesses until game over
        while (!game.isGameOver()) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt(); // assuming user provides valid integer

            boolean correct = game.makeGuess(guess);

            if (correct) {
                System.out.println("Correct! You won in " + game.getAttempts() + " attempts.");
                break;
            } else {
                // Show hint and remaining attempts
                System.out.println(game.getHint(guess));
                int remaining = game.getRemainingAttempts();
                System.out.println("Remaining attempts: " + remaining);
            }
        }

        // After loop, print final result
        if (game.isWon()) {
            System.out.println("Result: You win!");
        } else {
            System.out.println("Result: You lose. The number was hidden in the game state.");
            // For demonstration reveal:
            System.out.println(game.toString());
        }

        // Demonstrate equals() by comparing two games
        GuessGame anotherGame = new GuessGame(5); // new random number
        System.out.println("Game equals anotherGame? " + game.equals(anotherGame));
        System.out.println("Game hashCode: " + game.hashCode());
        System.out.println("AnotherGame hashCode: " + anotherGame.hashCode());

        // Close scanner
        scanner.close();
    }
}