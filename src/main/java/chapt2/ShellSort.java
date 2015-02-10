package chapt2;

import static chapt2.SortHelper.*;

public class ShellSort implements Sort {

    public void sort(Comparable[] a) {
        int N = a.length, h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h > 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j > h && less(a[j], a[j - 1]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
