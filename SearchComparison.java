import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Linear Search (O(N))
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Binary Search (O(log N))
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 1_000_000};
        Random rand = new Random();

        System.out.println("Dataset Size    Linear Search (ms)    Binary Search (ms)");

        for (int N : sizes) {
            int[] data = new int[N];

            // Generate random dataset
            for (int i = 0; i < N; i++) {
                data[i] = rand.nextInt(N);
            }

            int target = data[N - 1];

            // Measure Linear Search time
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long linearTime = (System.nanoTime() - startTime) / 1_000_000; // Convert to milliseconds

            // Sort the array for Binary Search
            startTime = System.nanoTime();
            Arrays.sort(data);
            long sortTime = (System.nanoTime() - startTime) / 1_000_000;

            // Measure Binary Search time
            startTime = System.nanoTime();
            binarySearch(data, target);
            long binaryTime = (System.nanoTime() - startTime) / 1_000_000;


            System.out.println(N + "                " + linearTime + " ms               " + (binaryTime + sortTime) + " ms");
        }
    }
}