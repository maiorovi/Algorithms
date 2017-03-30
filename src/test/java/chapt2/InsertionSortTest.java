package chapt2;

import drivers.SortDriver;
import org.junit.Before;
import org.junit.Test;

import static chapt2.SortHelper.generateRandomArray;
import static chapt2.SortHelper.isSorted;
import static org.assertj.core.api.Assertions.assertThat;

public class InsertionSortTest {

    private Sort sort;
    private SortDriver driver;

    @Before
    public void setUp() {
        sort = new InsertionSort();
        driver = new SortDriver();
    }

    @Test
    public void shouldSortArray() {
        Integer[] arr = driver.makeSortingOnRandomData(sort);

        assertThat(isSorted(arr)).isTrue();
    }
}
