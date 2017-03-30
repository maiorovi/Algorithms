package stanford_course.quick_sort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import org.junit.Before;
import org.junit.Test;
import util.ClasspathResourceReader;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest {
	private QuickSort quickSort;
	private ClasspathResourceReader resourceReader;

	private Function<String, Integer[]> dataLoader = fileName -> resourceReader.readFile(fileName);

	@Before
	public void setUp() throws Exception {
		resourceReader = new ClasspathResourceReader();

		quickSort = new QuickSort(new DefaultPivotSelectionStrategy());
	}

	@Test
	public void partitionsArrayAroundPivot() throws Exception {
		Integer arr[] = {4,5,2,1,7,6,3};

		quickSort.partition(arr, 0, arr.length - 1);

		assertThat(arr).containsExactly(3,2,1,4,7,6,5);
	}

	@Test
	public void partitionsArrayWithCustomLimits() throws Exception {
		Integer arr[] = {4,5,2,1,7,6,3};

		quickSort.partition(arr, 1, arr.length - 1);

		assertThat(arr).containsExactly(4, 3, 2, 1, 5, 6, 7);

	}

	@Test
	public void sortsInputArrayInIncreasingOrder() throws Exception {
		Integer arr[] = {4,5,2,1,7,6,3};

		quickSort.sort(arr);

		assertThat(arr).containsExactly(1,2,3,4,5,6,7);
	}

	@Test
	public void countsNumberOfComparisonRequiredToSortArray() throws Exception {
		Integer arr[] = {4,5,2,1,7,6,3,8};

		quickSort.sort(arr);
		System.out.println(quickSort.getAcc());
		assertThat(arr).containsExactly(1,2,3,4,5,6,7,8);
	}

	@Test
	public void sortsCorretlyArrayWithDuplicates() throws Exception {
		Integer arr[] = {4,5,2,1,7,6,3,8,5,5};

		quickSort.sort(arr);
		assertThat(arr).containsExactly(1,2,3,4,5,5,5,6,7,8);
	}

	@Test
	public void sortsDataFromFile() throws Exception {
		Integer arr[] = dataLoader.apply("quicksort.txt");

		quickSort.sort(arr);
		assertThat(isSorted.test(arr)).isTrue();
	}

	private Integer[] loadDataFromFile(String fileName) {
		return resourceReader.readFile(fileName);
	}

	private Predicate<Integer[]> isSorted = arr -> {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i+1]) {
				return false;
			}
		}

		return true;
	};

	@Test
	public void isSortedReturnsFalseForUnsortedArray() throws Exception {
		assertThat(isSorted.test(new Integer[]{1,2,3,4,7, 5})).isFalse();
	}

	@Test
	public void isSortedReturnsTrueForUnsortedArray() throws Exception {
		assertThat(isSorted.test(new Integer[]{1,2,3,4,5,7})).isTrue();
	}
}
