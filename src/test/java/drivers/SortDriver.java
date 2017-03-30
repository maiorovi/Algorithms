package drivers;

import chapt2.Sort;

import static chapt2.SortHelper.generateRandomArray;

public class SortDriver {

    public Integer[] makeSortingOnRandomData(Sort sort) {
        Integer[] arr = new Integer[100];
        generateRandomArray(arr, 100);

        sort.sort(arr);

        return arr;
    }
}
