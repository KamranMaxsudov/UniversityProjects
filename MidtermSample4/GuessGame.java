package MidtermSample4;

import java.util.Random;

public class GuessGame {

    // Required private fields
    private int randomNumber;
    private int maxAttempts;
    private int attempts;
    private boolean isWon;

    // Additional private fields to support range-based generation
    private int min;
    private int max;

    // Constructor 1: default range 1..100
    public GuessGame(int maxAttempts) {
        this(maxAttempts, 1, 100); // constructor chaining
    }

    // Constructor 2: specify attempt limit and range (min..max)
    public GuessGame(int maxAttempts, int min, int max) {
        // Validate maxAttempts (1..10)
        if (maxAttempts >= 1 && maxAttempts <= 10) {
            this.maxAttempts = maxAttempts;
        } else {
            this.maxAttempts = 5; // sensible default when invalid
        }

        // Ensure min/max are within 1..100 and min <= max
        if (min < 1) min = 1;
        if (max > 100) max = 100;
        if (min > max) { // fallback to full range if invalid
            min = 1;
            max = 100;
        }
        this.min = min;
        this.max = max;

        // Initialize game state
        this.attempts = 0;
        this.isWon = false;

        // Generate the first random number immediately
        generateRandomNumber();
    }

    // Generate a random number in the current [min, max] range
    public void generateRandomNumber() {
        Random rand = new Random();
        this.randomNumber = rand.nextInt(max - min + 1) + min;
        // Reset game state when a new number is generated
        this.attempts = 0;
        this.isWon = false;
    }

    // Make a guess. Returns true if guess is correct, false otherwise.
    // If guess is wrong, attempts increase (only if the game is not already over).
    public boolean makeGuess(int guess) {
        // If game already over, do nothing and return current win state
        if (isGameOver()) {
            return isWon;
        }

        // If guess correct
        if (guess == randomNumber) {
            isWon = true;
            return true;
        } else {
            // Wrong guess increments attempts
            attempts++;
            return false;
        }
    }

    // Provide hint for a guess: "Higher", "Lower", or "Correct"
    public String getHint(int guess) {
        if (guess < randomNumber) return "Higher";
        if (guess > randomNumber) return "Lower";
        return "Correct";
    }

    // Remaining attempts available
    public int getRemainingAttempts() {
        int remaining = maxAttempts - attempts;
        return remaining >= 0 ? remaining : 0;
    }

    // Whether the game has ended (won or attempts exhausted)
    public boolean isGameOver() {
        return isWon || attempts >= maxAttempts;
    }

    // Reset the game (keeps same range and attempt limit)
    public void resetGame() {
        this.attempts = 0;
        this.isWon = false;
        generateRandomNumber();
    }

    // Optional getters used by main or tests
    public int getMaxAttempts() {
        return maxAttempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isWon() {
        return isWon;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    // toString override
    @Override
    public String toString() {
        return "GuessGame{" +
                "randomNumber=" + randomNumber +
                ", maxAttempts=" + maxAttempts +
                ", attempts=" + attempts +
                ", isWon=" + isWon +
                ", range=[" + min + "," + max + "]" +
                '}';
    }

    // equals based on randomNumber and maxAttempts
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        GuessGame other = (GuessGame) obj;
        return this.randomNumber == other.randomNumber
                && this.maxAttempts == other.maxAttempts;
    }

    // hashCode consistent with equals
    @Override
    public int hashCode() {
        int result = Integer.hashCode(maxAttempts);
        result = 31 * result + Integer.hashCode(randomNumber);
        return result;
    }
}