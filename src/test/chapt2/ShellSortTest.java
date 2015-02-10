package chapt2;

import org.junit.Before;
import org.junit.Test;

import static chapt2.SortHelper.generateRandomArray;
import static chapt2.SortHelper.isSorted;
import static org.assertj.core.api.Assertions.assertThat;

public class ShellSortTest {

    private Sort sort;

    @Before
    public void setUp() {
        sort = new ShellSort();
    }

    @Test
    public void shouldSortArray() {
        Integer[] arr = new Integer[100];
        generateRandomArray(arr, 100);

        sort.sort(arr);

        assertThat(isSorted(arr)).isTrue();
    }
}
