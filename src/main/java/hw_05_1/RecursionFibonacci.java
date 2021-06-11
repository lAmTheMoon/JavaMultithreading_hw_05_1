package hw_05_1;

public class RecursionFibonacci {
    public int getFibonacciNumber(int n) {
        if (n <= 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
    }
}
