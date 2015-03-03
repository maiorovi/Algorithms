package chapt5;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer, String> tree;

    @Before
    public void setUp() {
        tree = new BinarySearchTree<Integer, String>();
    }

    @Test
    public void shouldReturnElementsWhichWasPutToDataStructure() {
        initBinarySearchTree();

        assertThat(tree.get(1)).isEqualTo("Egor");
        assertThat(tree.get(2)).isEqualTo("Andrew");
    }

    private void initBinarySearchTree() {
        tree.put(1, "Egor");
        tree.put(2, "Andrew");
        tree.put(3, "Zahar");

    }

    @Test
    public void shouldReturnMinimalElementInTree() {
        initBinarySearchTree();

        assertThat(tree.min()).isEqualTo("Egor");
    }

    @Test
    public void shouldReturnMaximumElementInTree() {
        initBinarySearchTree();

        assertThat(tree.max()).isEqualTo("Zahar");
    }

}
