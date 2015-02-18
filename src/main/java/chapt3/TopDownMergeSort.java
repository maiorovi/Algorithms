package chapt3;

import chapt2.Sort;
import static chapt2. SortHelper.*;

public class TopDownMergeSort extends MergeSort {

    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int high) {
        if (lo >= high) {
            return;
        }

        int mid = lo + (high - lo) / 2;

        sort(a, lo, mid);
        sort(a, mid + 1, high);
        merge(a, lo, mid, high);
    }


}
