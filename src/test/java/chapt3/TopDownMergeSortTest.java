package chapt3;

import drivers.SortDriver;
import org.junit.Before;
import org.junit.Test;

import static chapt2.SortHelper.isSorted;
import static org.assertj.core.api.Assertions.assertThat;

public class TopDownMergeSortTest {

    private TopDownMergeSort sort;
    private SortDriver driver;

    @Before
    public void setUp() {
        sort = new TopDownMergeSort();
        driver =new SortDriver();
    }

    @Test
    public void shouldSortArray() {
        Integer array[] = driver.makeSortingOnRandomData(sort);

        assertThat(isSorted(array)).isTrue();
    }
}
