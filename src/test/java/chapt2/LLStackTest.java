package chapt2;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LLStackTest {

    private LLStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new LLStack<Integer>();
    }

    @Test
    public void shouldPutValueIntoStack() {
        stack.push(1);
        assertThat(stack.pop()).isEqualTo(1);
    }

}
