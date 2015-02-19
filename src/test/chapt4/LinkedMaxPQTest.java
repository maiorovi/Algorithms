package chapt4;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedMaxPQTest {

    private LinkedMaxPQ<Integer> pq;

    @Before
    public void setUp() {
        pq = new LinkedMaxPQ<Integer>();
        populateQueue();
    }

    @Test
    public void shouldReturnMaxElementInQueue() {
        Integer actual = pq.max();
        assertThat(actual).isEqualTo(19);
    }

    @Test
    public void shouldReturnMaxElementInQueueAndDeleteIt() {
        assertThat(pq.delMax()).isEqualTo(19);
        assertThat(pq.delMax()).isEqualTo(18);
        assertThat(pq.delMax()).isEqualTo(17);
    }

    @Test
    public void shouldReturnQueueSize() {
        assertThat(pq.size()).isEqualTo(20);
    }

    @Test
    public void shouldReturnisQueueEmpty() {
        assertThat(pq.isEmpty()).isFalse();
    }

    private void populateQueue() {
        for (int i = 0; i < 20; i++) {
            pq.insert(i);
        }
    }
}
