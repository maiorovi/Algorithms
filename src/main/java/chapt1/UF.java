package chapt1;

public interface UF {

    public void union(int p, int q);
    public boolean connected(int p, int q);
    public int find(int p);
}
