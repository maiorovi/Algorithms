package chapt4;

public class HeapMaxPQ<Type extends Comparable> implements PriorityQueue<Type> {

    private Type[] container;
    private int N;

    public HeapMaxPQ() {
        container = (Type[]) new Comparable[10];
    }

    @Override
    public void insert(Type value) {
        container[++N] = value;
        swim(container, N);
    }

    private void swim(Type[] container, int k) {
        while( k/2 > 1 && less(container[k/2], container[k]) ) {
                exch(k/2, k);
                k = k / 2;
            }
    }

    private boolean less(Comparable one, Comparable two) {
        return one.compareTo(two) < 0;
    }

    private void exch(int i, int j) {
        Type temp = container[i];
        container[i] = container[j];
        container[j] = temp;
    }

    @Override
    public Type max() {
        return null;
    }

    @Override
    public Type delMax() {
        Type max = container[1];
        exch(1, N--);
        container[N+1] = null;
        sink(container, 1);
        return max;
    }

    private void sink(Type[] container, int k) {
        while(2*k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    @Override
    public boolean isEmpty() {
        return  N == 0;
    }

    @Override
    public int size() {
        return N;
    }
}
