package stanford_course.quick_sort;

import org.junit.Before;
import org.junit.Test;
import util.ClasspathResourceReader;

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

		quickSort = new QuickSort(new FirstElementPivotSelectionStrategy());
	}

	@Test
	public void simpleArrayFrom1To20() throws Exception {
		Integer[] arr = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		quickSort.sort(arr);

		assertThat(isSorted.test(arr)).isTrue();
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
		System.out.println(quickSort.getComparisonNumbers());
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

	@Test
	public void sortsArrayUsingTakeLastAsPivotStrategy() throws Exception {
		quickSort = new QuickSort(new LastElementPivotSelectionStrategy());
		Integer arr[] = {4,5,2,1,7,6,3,8,5,5};

		quickSort.sort(arr);
		assertThat(arr).containsExactly(1,2,3,4,5,5,5,6,7,8);
	}


	@Test
	public void sortsDataFromFileUsingTakeFirstPivotSelectionStrategy() throws Exception {
		quickSort = new QuickSort(new FirstElementPivotSelectionStrategy());
		Integer arr[] = dataLoader.apply("quicksort.txt");

		quickSort.sort(arr);
		System.out.println(quickSort.getComparisonNumbers());
		assertThat(quickSort.getComparisonNumbers()).isEqualTo(162085);
		assertThat(isSorted.test(arr)).isTrue();
	}

	@Test
	public void sortsDataFromFileUsingTakeLastPivotSelectionStrategy() throws Exception {
		quickSort = new QuickSort(new LastElementPivotSelectionStrategy());
		Integer arr[] = dataLoader.apply("quicksort.txt");

		quickSort.sort(arr);
		System.out.println(quickSort.getComparisonNumbers());
		System.out.println("brute force: " + quickSort.getBruteForceComparisonNumbers());
		assertThat(quickSort.getComparisonNumbers()).isEqualTo(164123);
		assertThat(isSorted.test(arr)).isTrue();
	}

	@Test
	public void sortsDataFromFileUsingTakeMedianPivotSelectionStrategy() throws Exception {
		quickSort = new QuickSort(new MedianElementPivotSelectionStrategy());
		Integer arr[] = dataLoader.apply("quicksort.txt");

		quickSort.sort(arr);
		System.out.println(quickSort.getComparisonNumbers());
		System.out.println("brute force: " + quickSort.getBruteForceComparisonNumbers());
//		assertThat(quickSort.getComparisonNumbers()).isEqualTo(156383);
		assertThat(isSorted.test(arr)).isTrue();
	}

	@Test
	public void sortsSimpleArrayAndOutputNumberOfComparisonsCorrectly() throws Exception {
		quickSort = new QuickSort(new FirstElementPivotSelectionStrategy());
		Integer arr[] = {4,3,2,1};

		quickSort.sort(arr);
		System.out.println(quickSort.getComparisonNumbers());
		System.out.println("brute force: " + quickSort.getBruteForceComparisonNumbers());
	}

	private Predicate<Integer[]> isSorted = arr -> {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i+1]) {
				System.out.println(arr[i] + " " + arr[i+1]);
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
