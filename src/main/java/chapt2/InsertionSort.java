package chapt2;

import static chapt2.SortHelper.*;

public class InsertionSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        for(int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
