import java.util.Collection;

public class MyArrayList {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Добавление элемента
    public void add(Object element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    // Добавление коллекции
    public void addAll(Collection<?> c) {
        for (Object element : c) {
            add(element);
        }
    }

    // Получение элемента по индексу
    public Object get(int index) {
        checkIndex(index);
        return elements[index];
    }

    // Удаление элемента по индексу
    public Object remove(int index) {
        checkIndex(index);
        Object removed = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removed;
    }

    // Проверка индекса
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Увеличение емкости
    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public int size() {
        return size;
    }
}