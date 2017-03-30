package stanford_course.quick_sort;

public interface PivotSelectionStrategy {

	int choosePivot(int[] arr, int lo, int high);
}
