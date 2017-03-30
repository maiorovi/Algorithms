package stanford_course.quick_sort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest {
	private QuickSort quickSort;


	@Before
	public void setUp() throws Exception {
		quickSort = new QuickSort(new DefaultPivotSelectionStrategy());
	}

	@Test
	public void partitionsArrayAroundPivot() throws Exception {
		int arr[] = {4,5,2,1,7,6,3};

		quickSort.partition(arr, 0, arr.length - 1);

		assertThat(arr).containsExactly(3,2,1,4,7,6,5);
	}

	@Test
	public void partitionsArrayWithCustomLimits() throws Exception {
		int arr[] = {4,5,2,1,7,6,3};

		quickSort.partition(arr, 1, arr.length - 1);

		assertThat(arr).containsExactly(4, 3, 2, 1, 5, 6, 7);
	}

	@Test
	public void sortsInputArrayInIncreasingOrder() throws Exception {
		int arr[] = {4,5,2,1,7,6,3};

		quickSort.sort(arr);

		assertThat(arr).containsExactly(1,2,3,4,5,6,7);
	}
}
