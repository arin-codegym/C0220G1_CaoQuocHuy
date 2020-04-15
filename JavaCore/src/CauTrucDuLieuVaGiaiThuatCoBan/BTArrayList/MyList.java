package CauTrucDuLieuVaGiaiThuatCoBan.BTArrayList;

import java.util.Arrays;

public class MyList<E> {
    int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[capacity];
        } else if (capacity == 0) {
            this.elements = new Object[]{};
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    capacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out");
        }
    }

    void add(int index, E element) {
        checkIndex(index);
        if (element == null) {
            throw new NullPointerException("element invalid");
        }
        if (size > elements.length) {
            ensureCapacity(size);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    E remove(int index) {
        checkIndex(index);
        E e = (E) elements[index];
        e = (E) elements[index];
//        for (int i = index; i < size - 1; i++) {
//            elements[i] = elements[i + 1];}
//            elements[--size] = null;
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;

        return e;
    }

    int size() {
        return size;
    }

    public MyList<E> clone() {
//        E e = (E) Arrays.copyOf(elements, elements.length);
//        return e;
        MyList<E> newMyList = new MyList<E>();
        newMyList.elements = elements;
        newMyList.size = size;
        return newMyList;
    }

    boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    int indexOf(E e) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == e || elements[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            elements = Arrays.copyOf(elements, elements.length + minCapacity);
        }
    }

    boolean add(E e) {
        if (e == null) {
            return false;
        } else {
            for (int i = 0; i < size; i++) {
                if (elements.equals(e)) {
                    return false;
                }
            }
        }
        if (size == elements.length) {
            ensureCapacity(size);
            elements[size] = e;
            size++;
        }
        return true;
    }

    E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    void display() {
        for (int i = 0; i < elements.length; i++) {
            System.out.println("index: " + i + ", value: " + elements[i]);
        }

    }
}
