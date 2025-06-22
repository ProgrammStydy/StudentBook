import java.util.LinkedList;

public class MyHashSet {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Object>[] buckets;
    private int size;

    public MyHashSet() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    public void insert(Object key) {
        int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
        LinkedList<Object> bucket = buckets[bucketIndex];
        if (!bucket.contains(key)) {
            bucket.add(key);
            size++;
        }
    }

    public boolean remove(Object key) {
        int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
        LinkedList<Object> bucket = buckets[bucketIndex];
        boolean removed = bucket.remove(key);
        if (removed) size--;
        return removed;
    }

    public int size() {
        return size;
    }
}