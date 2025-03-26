import java.util.*;

public class SearchCompare {
    public static void main(String[] args) {
        int[] sizes = {1_000, 100_000, 1_000_000};

        System.out.println("Dataset Size    Array Search (ms)    HashSet Search (ms)    TreeSet Search (ms)");

        for (int size : sizes) {

            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                int num = rand.nextInt(size * 10);
                array[i] = num;
                hashSet.add(num);
                treeSet.add(num);
            }

            int searchValue = array[size / 2];


            long startTime = System.nanoTime();
            for (int num : array) {
                if (num == searchValue) break;
            }
            long arraySearchTime = (System.nanoTime() - startTime) / 1_000_000;


            startTime = System.nanoTime();
            hashSet.contains(searchValue);
            long hashSetSearchTime = (System.nanoTime() - startTime) / 1_000_000;


            startTime = System.nanoTime();
            treeSet.contains(searchValue);
            long treeSetSearchTime = (System.nanoTime() - startTime) / 1_000_000;


            System.out.println(size + "            " + arraySearchTime + " ms              " + hashSetSearchTime + " ms              " + treeSetSearchTime + " ms");
        }
    }
}