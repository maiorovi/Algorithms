package stanford_course.quick_sort;

public class LastElementPivotSelectionStrategy implements PivotSelectionStrategy {
	@Override
	public int choosePivot(Integer[] arr, int lo, int high) {
		return high;
	}
}
