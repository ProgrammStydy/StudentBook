import java.util.LinkedList;
import java.util.List;

public class MyHashSet<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private List<T>[] buckets;
    private int size;

    public MyHashSet() {
        buckets = (List<T>[]) new List[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    public void add(T key) {
        int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
        List<T> bucket = buckets[bucketIndex];
        if (!bucket.contains(key)) {
            bucket.add(key);
            size++;
        }
    }

    public boolean remove(T key) {
        int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
        List<T> bucket = buckets[bucketIndex];
        boolean removed = bucket.remove(key);
        if (removed) {
            size--;
        }
        return removed;
    }

    public int size() {
        return size;
    }
}