package chapt1;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeightedQuickUnionTest {

    private WeightedQuickUnion wqu;

    @Before
    public void setUp() {
        wqu = new WeightedQuickUnion(10);
    }

    @Test
    public void shouldUnionChoosenVertecies() {
        wqu.union(1,6);
        wqu.union(6,3);
        wqu.union(3,9);
        wqu.union(4,6);
        assertThat(wqu.connected(1,6)).isTrue();
    }

}
