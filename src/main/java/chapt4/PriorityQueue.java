package chapt4;

public interface PriorityQueue<Type> {

    public void insert(Type T);
    public Type max();
    public Type delMax();
    public boolean isEmpty();
    public int size();

}
