package stanford_course.quick_sort;

public class FirstElementPivotSelectionStrategy implements PivotSelectionStrategy {

	public int choosePivot(Integer[] arr, int low, int high) {
		return low;
	}

}
