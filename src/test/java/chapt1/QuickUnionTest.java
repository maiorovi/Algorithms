package chapt1;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickUnionTest {

    private QuickUnion qu;

    @Before
    public void setUp() {
        qu = new QuickUnion(10);
    }

    @Test
    public void shouldConnectChoosenVertecies() {
        qu.union(1,2);
        qu.union(1,9);
        qu.union(2,4);
        assertThat(qu.connected(4,9)).isTrue();
    }

}
