package chapt1;

public class QuickFind implements UF {

    int[] container;

    public QuickFind(int length) {
        container = new int[length];
        for (int i = 0; i < length; i++) {
            container[i] = i;
        }
    }


    @Override
    public void union(int p, int q) {
        for (int i = 0; i < container.length; i++) {
            if ( container[p] == container[q] ) {
                container[p] = container[q];
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return container[p] == container[q];
    }

    @Override
    public int find(int p) {
        return 0;
    }
}
