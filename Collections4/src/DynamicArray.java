import java.util.Arrays;

public class DynamicArray<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public DynamicArray() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public DynamicArray(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("Capacity cannot be negative");
        this.elements = new Object[initialCapacity];
    }

    public DynamicArray(T... values) {
        this.elements = Arrays.copyOf(values, values.length, Object[].class);
        this.size = values.length;
    }

    public static void main(String[] args) {
        DynamicArray<Integer> list = new DynamicArray<>(1, 2, 3);
        System.out.println("Начальный массив: " + list);
        list.addElement(4);
        list.addElement(1, 99);
        System.out.println("После добавлений: " + list);
        System.out.println("Элемент под индексом 2: " + list.getElement(2));
        list.setElement(0, 100);
        System.out.println("После замены 0-го элемента: " + list);
        list.removeElement(1);
        System.out.println("После удаления индекса 1: " + list);
        System.out.println("Содержит 100? " + list.containsElement(100));
        System.out.println("Текущий размер: " + list.getSize());
        try {
            list.getElement(10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = (elements.length == 0) ? 1 : elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds: " + index);
        }
    }

    public void addElement(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public void addElement(int index, T element) {
        if (index < 0 || index > size) throw new IllegalArgumentException("Invalid index");
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public void setElement(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    public T getElement(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    public void removeElement(int index) {
        checkIndex(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    public boolean containsElement(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] != null && elements[i].equals(element)) return true;
            if (elements[i] == null && element == null) return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DynamicArray)) return false;
        DynamicArray<?> that = (DynamicArray<?>) o;
        if (this.size != that.size) return false;
        for (int i = 0; i < size; i++) {
            if (!this.elements[i].equals(that.elements[i])) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < size; i++) {
            result = 31 * result + (elements[i] == null ? 0 : elements[i].hashCode());
        }
        return result;
    }
}

