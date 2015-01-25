package chapt1;

public class QuickUnion implements UF {
    private int[] id;

    public QuickUnion(int length) {
        id = new int[length];
        for (int i = 0; i < id.length; i++) {

        }
    }


    @Override
    public void union(int p, int q) {
        id[p] = id[q];
    }

    @Override
    public boolean connected(int p, int q) {

        return root(p) == root(q);
    }

    private int root(int p) {
        if (p == id[p]) {
            return id[p];
        }
        return root(id[p]);
    }

    @Override
    public int find(int p) {
        return 0;
    }
}
