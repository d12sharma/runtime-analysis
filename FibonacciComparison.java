public class FibonacciComparison {
    public static void main(String[] args) {
        int[] testCases = {10, 30, 50};

        System.out.println("Fibonacci (N)    Recursive (ms)    Iterative (ms)");

        for (int n : testCases) {

            long startTime = System.nanoTime();
            fibonacciRecursive(n);
            long recursiveTime = (System.nanoTime() - startTime) / 1_000_000;


            startTime = System.nanoTime();
            fibonacciIterative(n);
            long iterativeTime = (System.nanoTime() - startTime) / 1_000_000;


            System.out.println(n + "                " +
                    (recursiveTime > 3_600_000 ? "Unfeasible (>1hr)" : recursiveTime + " ms") + "         " +
                    iterativeTime + " ms");
        }
    }


    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }


    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}