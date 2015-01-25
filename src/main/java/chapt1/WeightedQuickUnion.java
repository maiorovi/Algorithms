package chapt1;

public class WeightedQuickUnion implements UF{

    private int[] id;
    private int[] sz;

    public WeightedQuickUnion(int length) {
        id = new int[length];
        sz = new int[length];
        for (int i = 0; i < length; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        if (pid == qid)
            return;
        if (sz[pid] > sz[qid]) {
            id[qid] = pid;
            sz[pid] += sz[qid];
        } else {
            id[pid] = qid;
            sz[qid] += sz[pid];
        }

    }

    private int root(int p) {
        if (p == id[p]) {
            return p;
        }
        return root(id[p]);
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int find(int p) {
        return 0;
    }
}
