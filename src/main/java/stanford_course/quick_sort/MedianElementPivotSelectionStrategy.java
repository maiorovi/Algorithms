package stanford_course.quick_sort;

import java.util.Arrays;

public class MedianElementPivotSelectionStrategy implements PivotSelectionStrategy {
	@Override
	public int choosePivot(Integer[] arr, int lo, int high) {
		int medianIndex = -1;
		int length = high - lo + 1;
		if (length % 2 != 0) {
			medianIndex = lo +  length / 2;
		} else {
			medianIndex =  lo + ((length / 2) - 1);
		}

		int[] tmp = new int[3];
		tmp[0] = arr[lo];
		tmp[1] = arr[medianIndex];
		tmp[2] = arr[high];

		Arrays.sort(tmp);

		if (tmp[1] == arr[lo]) {
			return lo;
		} else if(tmp[1] == arr[medianIndex]) {
			return  medianIndex;
		} else if (tmp[1] == arr[high]) {
			return high;
		}

		return 0;
//				findMiddleElement(arr, lo, high, medianIndex);
	}

	private int findMiddleElement(Integer[] arr, int one, int two, int three) {
		int mid = -1;

		if ((arr[one] >= arr[two] && arr[one] <= arr[three]) ||
				(arr[one] <= arr[two] && arr[one] >= arr[three]) ) {
			mid = one;
		} else if ((arr[two] >= arr[one] && arr[two] <= arr[three]) ||
				(arr[two] <= arr[one] && arr[two] >= arr[three]) ) {
		 	mid = two;
		} else if ((arr[three] >= arr[two] && arr[three] <= arr[one]) ||
				(arr[three] <= arr[two] && arr[three] >= arr[one]) ) {
			mid = three;
		}


		return mid;
	}

}
