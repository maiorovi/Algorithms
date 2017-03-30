package stanford_course.quick_sort;

public interface PivotSelectionStrategy {

	int choosePivot(Integer[] arr, int lo, int high);
}
