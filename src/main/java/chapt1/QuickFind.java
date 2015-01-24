package chapt1;

public class QuickFind implements UF {

    private int[] container;

    public QuickFind(int length) {
        container = new int[length];
        for (int i = 0; i < length; i++) {
            container[i] = i;
        }
    }


    @Override
    public void union(int p, int q) {
        int pid = container[p];
        int qid = container[q];

        for (int i = 0; i < container.length; i++) {
            if ( pid == container[i] ) {
                container[i] = qid;
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
