package chapt2;

import java.util.Random;

public class SortHelper {

    public static void exch(Comparable a[], int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static boolean isSorted(Comparable a[]) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }

        return true;
    }

    public static void  generateRandomArray(Comparable<Integer> arr[], int maxValue) {
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(maxValue);
        }
    }

    public static void generateRandomArray(Comparable<Integer> arr[]) {
        generateRandomArray(arr, Integer.MAX_VALUE);
    }

    public static void printArray(Comparable[] arr) {
        for (int i =0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
