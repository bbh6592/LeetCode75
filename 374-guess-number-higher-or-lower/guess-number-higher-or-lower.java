public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid; // Found the number
            } else if (result < 0) {
                high = mid - 1; // Guess is too high
            } else {
                low = mid + 1; // Guess is too low
            }
        }

        return -1; // Should never reach here
    }
}
