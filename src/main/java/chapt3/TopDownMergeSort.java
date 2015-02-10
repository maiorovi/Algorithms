package chapt3;

import chapt2.Sort;
import static chapt2. SortHelper.*;

public class TopDownMergeSort implements Sort {

    Comparable[] aux;

    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
        aux = new Comparable[a.length];
    }

    private void sort(Comparable[] a, int lo, int high) {
        if (lo >= high) {
            return;
        }

        int mid = lo + (high - lo) / 2;

        sort(a, lo, mid);
        sort(a, mid+1, high);
        merge(a, lo, mid, high);
    }

    private void merge(Comparable a[], int lo, int mid, int high) {

        for (int i = lo; i <= high; i++) {
                aux[i] = a[i];
        }

        int i = lo, j = mid + 1;

        for(int k = lo; k <= high; k++) {
            if (i > mid)       a[k] = aux[j++];
            else if (j > high)  a[k] = aux[i++];
            else if (less(aux[i], aux[j]))  a[k] = aux[i++];
            else a[k] = aux[j++];
    }
}
