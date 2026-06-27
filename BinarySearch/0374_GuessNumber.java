package BinarySearch;

// This part is a solution to the LeetCode problem "Guess Number Higher or Lower" (Problem 374).
// The code defines a class `GuessGame` that simulates the behavior of guessing a number,
//  and the `GuessNumber_0374` class extends `GuessGame` and implements a binary search algorithm to find the guessed number within a given range.

class GuessGame {
    // Change this to test different answers
    private int picked = 6;

    public int guess(int num) {
        if (num > picked) return -1;
        if (num < picked) return 1;
        return 0;
    }
}

class Problem0374_GuessNumber extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (guess(mid) == 1) {
                left = mid + 1;
            } else if (guess(mid) == -1) {
                right = mid;
            } else {
                return mid;
            }
        }

        return left;
    }
    public static void main(String[] args) {
        Problem0374_GuessNumber obj = new Problem0374_GuessNumber();

        int n = 10;
        int ans = obj.guessNumber(n);

        System.out.println("Guessed number = " + ans);
    }
}


    
