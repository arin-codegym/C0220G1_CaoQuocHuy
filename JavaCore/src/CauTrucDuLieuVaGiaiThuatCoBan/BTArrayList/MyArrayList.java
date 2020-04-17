package CauTrucDuLieuVaGiaiThuatCoBan.BTArrayList;

import java.util.Arrays;

public class MyArrayList<E> {
    /**
     * Số lượng phần tử có trong MyList
     */
    int size = 0;
    /**
     * Sức chứa mặc định của My List
     */
    static final int DEFAULT_CAPACITY = 2;
    /**
     * Mảng chứa các phần tử
     */
    Object elements[];

    /**
     * Sức chứa mặc định khi khởi tạo bằng contructor không có tham số
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Phương thức contructor với sức chứa được truyền vào
     *
     * @param capacity
     */
    public MyArrayList(int capacity) {
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
        if (index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException("Index out");
        }
    }

    /**
     * PT xóa phần tử tại vị trí index
     *
     * @param index
     * @return
     */

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

    /**
     * Phương thức trả về số lượng phần tử
     *
     * @return
     */
    int size() {
        return size;
    }

    /**
     * Phương thức nhân bản ArrayList
     * @return
     */
    public MyArrayList<E> clone() {
//        E e = (E) Arrays.copyOf(elements, elements.length);
//        return e;
        MyArrayList<E> newMyList = new MyArrayList<E>();
        newMyList.elements = elements;
        newMyList.size = size;
        return newMyList;
    }

    /**
     * PT kiểm tra 1 phần tử có tồn tại trong mảng hay không?
     * @param e
     * @return
     */
    boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    /**
     * PT lấy index của một phần tử
     * @param e
     * @return
     */
    int indexOf(E e) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == e || elements[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * PT tăng kich thước MyList khi số lượng phần tử vượt quá kich thước của nó
     *
     * @param minCapacity
     */
    void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity:" + minCapacity);
        }
    }

    /**
     * PT add 1 phần tử vào MyList
     *
     * @param e là phần tử truyền vào
     * @return
     */
    boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity(1);
        }
        elements[size] = e;
        size++;
        return true;
    }

    /**
     * PT add phần từ vào vị trí tại index
     *
     * @param index
     * @param element
     */
    void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index" + size);
        } else if (elements.length == size) {
            ensureCapacity(2);
        }
        if (elements[index]==null){
            elements[index]=element;
            size++;
        }else {
            for (int i=size+1;i>=index;i--){
                elements[i]=elements[i-1];
            }
            elements[index]=element;
            size++;
        }
    }
    // use System.arraycopy method()
//    void add(int index, E element) {
//        checkIndex(index);
//        if (elements[index] == null) {
//            throw new NullPointerException("element invalid");
//        }
//       else if (size > elements.length) {
//            ensureCapacity(1);
//        }
//        System.arraycopy(elements, index, elements, index + 1, size - index);
//        elements[index] = element;
//        size++;
//    }

    /**
     * PT lấy phần tử tại index
     * @param index
     * @return
     */

    E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    /**
     * PP clear MyList
     */
    void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Phương thức in mảng
     */
    void display() {
        for (int i = 0; i < elements.length; i++) {
            System.out.println("index: " + i + ", value: " + elements[i]);
        }

    }
}
