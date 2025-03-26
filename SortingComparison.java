import java.util.Arrays;
import java.util.Random;

public class SortingComparison {


    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }


    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }


    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 1_000_000};
        Random rand = new Random();

        System.out.println("Dataset Size    Bubble Sort (ms)    Merge Sort (ms)    Quick Sort (ms)");

        for (int N : sizes) {
            int[] arr1 = new int[N];
            int[] arr2 = new int[N];
            int[] arr3 = new int[N];

            for (int i = 0; i < N; i++) {
                int num = rand.nextInt(N);
                arr1[i] = num;
                arr2[i] = num;
                arr3[i] = num;
            }


            long bubbleTime = -1;
            if (N <= 10_000) {
                long startTime = System.nanoTime();
                bubbleSort(arr1);
                bubbleTime = (System.nanoTime() - startTime) / 1_000_000;
            }


            long startTime = System.nanoTime();
            mergeSort(arr2, 0, N - 1);
            long mergeTime = (System.nanoTime() - startTime) / 1_000_000;


            startTime = System.nanoTime();
            quickSort(arr3, 0, N - 1);
            long quickTime = (System.nanoTime() - startTime) / 1_000_000;


            System.out.println(N + "              " +
                    (bubbleTime == -1 ? "Unfeasible" : bubbleTime + " ms") + "           " +
                    mergeTime + " ms           " +
                    quickTime + " ms");
        }
    }
}