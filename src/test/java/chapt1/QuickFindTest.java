package chapt1;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickFindTest {

    private QuickUnion qu;

    @Before
    public void setUp() {
        qu = new QuickUnion(10);
    }


    @Test
    public void test() {
        qu.union(1,2);
        qu.union(2,3);
        assertThat(qu.connected(1, 3)).isEqualTo(true);
    }
}
