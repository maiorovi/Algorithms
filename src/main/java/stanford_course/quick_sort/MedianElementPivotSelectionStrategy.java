package stanford_course.quick_sort;

public class MedianElementPivotSelectionStrategy implements PivotSelectionStrategy {
	@Override
	public int choosePivot(Integer[] arr, int lo, int high) {
		int medianIndex = -1;

		if (arr.length % 2 != 0) {
			medianIndex = arr.length / 2;
		} else {
			medianIndex = (arr.length / 2) - 1;
		}





		return findMiddleElement(arr, lo, high, medianIndex);
	}

	private int findMiddleElement(Integer[] arr, int one, int two, int three) {
		int mid = -1;

		if ((arr[one] >= arr[two] && arr[one] <= arr[three]) ||
				(arr[one] <= arr[two] && arr[one] >= arr[three]) )
			mid = one;

		if ((arr[two] >= arr[one] && arr[two] <= arr[three]) ||
				(arr[two] <= arr[one] && arr[two] >= arr[three]) )
			mid = two;

		if ((arr[three] >= arr[two] && arr[three] <= arr[one]) ||
				(arr[three] <= arr[two] && arr[three] >= arr[one]) )
			mid = three;


		return mid;
	}

}
