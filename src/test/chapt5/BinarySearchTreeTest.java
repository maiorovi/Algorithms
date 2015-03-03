package chapt5;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeTest {

    private BinarySearchTree<String, Integer> tree;

    @Before
    public void setUp() {
        tree = new BinarySearchTree<String, Integer>();
    }

    @Test
    public void shouldReturnElementsWhichWasPutToDataStructure() {
        tree.put("Egor", 1);
        tree.put("Andrew", 2);
        tree.put("Zahar", 3);
        assertThat(tree.get("Egor")).isEqualTo(1);
        assertThat(tree.get("Andrew")).isEqualTo(2);
    }

}
