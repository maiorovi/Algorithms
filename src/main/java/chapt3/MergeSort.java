package chapt3;


import chapt2.Sort;

import static chapt2.SortHelper.less;

public abstract class MergeSort implements Sort {

    protected Comparable[] aux;

    public abstract void sort(Comparable[] a);

    protected void merge(Comparable a[], int lo, int mid, int high) {

        for (int i = lo; i <= high; i++) {
            aux[i] = a[i];
        }

        int i = lo, j = mid + 1;

        for (int k = lo; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
}
