package stanford_course.quick_sort;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MedianElementPivotSelectionStrategyTest {

	MedianElementPivotSelectionStrategy medianElementPivotSelectionStrategy;

	@Before
	public void setUp() throws Exception {
		medianElementPivotSelectionStrategy = new MedianElementPivotSelectionStrategy();
	}

	@Test
	public void selectsMedianAsPivot() throws Exception {
		Integer[] input = {1, 2, 3, 4, 5};
		assertThat(medianElementPivotSelectionStrategy.choosePivot(input, 0, input.length - 1)).isEqualTo(2);
	}

	@Test
	public void selectsFstElementAsPivot() throws Exception {
		Integer[] input = {4, 2, 1, 4, 5};
		assertThat(medianElementPivotSelectionStrategy.choosePivot(input, 0, input.length - 1)).isEqualTo(0);
	}

	@Test
	public void selectsLstElementAsPivot() throws Exception {
		Integer[] input = {1, 4, 12, 6, 3};
		assertThat(medianElementPivotSelectionStrategy.choosePivot(input, 0, input.length - 1)).isEqualTo(4);
	}

	@Test
	public void selectsMedianElementAsPivotWhenArrayContainEvenNumberOfElements() throws Exception {
		Integer[] input = {4, 5, 6, 7};
		assertThat(medianElementPivotSelectionStrategy.choosePivot(input, 0, input.length - 1)).isEqualTo(1);
	}

	@Test
	public void selectsFstElementAsPivotWhenArrayContainEvenNumberOfElements() throws Exception {
		Integer[] input = {3, 2, 1, 4, 5, 6};
		assertThat(medianElementPivotSelectionStrategy.choosePivot(input, 0, input.length - 1)).isEqualTo(0);
	}

	@Test
	public void worksCorrectlyWithSubArray() throws Exception {
		// 4,5,6,7,8
		Integer[] input = {1,2,3,4,5,6,7,8,9,10};
		assertThat(medianElementPivotSelectionStrategy.choosePivot(input, 3, 7)).isEqualTo(5);
	}
}
