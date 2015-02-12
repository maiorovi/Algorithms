package chapt3;

import chapt2.Sort;

public class BottomUpMergeSort extends MergeSort {

    public void sort(Comparable[] a) {
        int N = a.length;

        for (int sz = 1; sz < N; sz = sz + sz ) {
            for(int j = 0; j < N ; j += sz) {
                merge(a, j, j + sz - 1, Math.min(j+sz+sz-1, N - 1));
            }
        }
    }


}
