package chapt2;

import static chapt2.SortHelper.exch;
import static chapt2.SortHelper.less;

public class SelectionSort implements Sort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        for(int i = 0; i < N; i++) {
            int min = i;
            for(int j = i; j < N; j++) {


                if (less(a[j],a[min])) {
                    min = j;
                }

            }
            exch(a, min, i);
        }
    }
}
