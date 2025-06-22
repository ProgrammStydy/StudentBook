import java.util.Collection;

public class MyArrayList {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(Object element) {
        if (size == elements.length) resize();
        elements[size++] = element;
    }

    public void addAll(Collection<?> c) {
        for (Object element : c) add(element);
    }

    public Object get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public Object remove(int index) {
        checkIndex(index);
        Object removed = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removed;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public int size() {
        return size;
    }
}