package chapt4;

public class ArrayMaxPQ<Type extends Comparable> implements PriorityQueue<Type> {

    private Type[] container;
    private int N;

    public ArrayMaxPQ() {
        container = (Type[]) new Comparable[10];
    }

    @Override
    public void insert(Type value) {
        if (N == container.length) {
            resizeArray(container, container.length*2);
        }
        container[N++] = value;
    }

    private void resizeArray(Type[] array, int size) {
        Type[] tempArray = (Type[]) new Comparable[size];

        for(int i = 0; i < N; i++) {
            tempArray[i] = array[i];
        }

        container = tempArray;
    }

    @Override
    public Type max() {
        return container[findMaxValue()];
    }

    @Override
    public Type delMax() {
        if (container.length / 4 == N) {
            resizeArray(container, container.length / 2);
        }

        int maxIndex = findMaxValue();

        exch(container, N - 1, maxIndex);
        Type max = container[N - 1];
        container[--N] = null;

        return max;
    }

    private int findMaxValue() {
        int maxIndex = 0;

        for(int i = 0; i < N; i++) {
            if ( container[maxIndex].compareTo(container[i]) < 0) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    private void exch(Type[] container, int i, int j) {
        Type  temp = container[i];
        container[i] = container[j];
        container[j] = temp;

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
