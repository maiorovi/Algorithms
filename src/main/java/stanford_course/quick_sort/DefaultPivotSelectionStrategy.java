package stanford_course.quick_sort;

public class DefaultPivotSelectionStrategy implements PivotSelectionStrategy {

	public int choosePivot(int[] arr, int low, int high) {
		return low;
	}

}
