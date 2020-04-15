package CauTrucDuLieuVaGiaiThuatCoBan.BTLinkedList;

public class MyLinkedList<E> implements Cloneable  {
    private Node head;
    private int numNodes = 0;

    private static class Node {
        Node next;
        Object data;

        public Node() {
        }

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public MyLinkedList() {
        head = null;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index out");
        }
    }

    public void add(int index, Object data) {
        checkIndex(index);
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(Object data) {
        if (data == null) {
            head = null;
        } else {
            Node temp = head;
            head = new Node(data);
            head.next = temp;
        }
        numNodes++;
    }

    public void addLast(Object data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            for (int i = 0; i < numNodes - 1; i++) {
                temp = temp.next;
            }
            temp.next = new Node(data);
            numNodes++;
        }
    }

    Object remove(int index) {
        checkIndex(index);
        Node temp = head;
        Node holder;
        Node nodeDel = head;
        if (index == 0) {
            head = temp.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
                nodeDel = temp.next;
            }
            holder = temp.next.next;
            temp.next = holder;
        }
        numNodes--;
        return nodeDel.getData();

    }

    public boolean remove(Object data) {
        while (true) {
            if (indexOf(data) >= 0) {
                remove(indexOf(data));
            } else break;
        }
        return true;
    }

    public int size() {
        return numNodes;
    }

    public MyLinkedList clone() {
//        MyLinkedList newMyLinkedList = new MyLinkedList();
//        newMyLinkedList.head = head;
//        newMyLinkedList.numNodes = numNodes;
//        return newMyLinkedList;
        try {
            MyLinkedList<E> linkedList = (MyLinkedList<E>) super.clone();
            return linkedList;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }


    }

    int indexOf(Object data) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData() == null || temp.getData().equals(data)) {
                temp = temp.next;
                return i;
            }
        }
        return -1;
    }

    boolean contains(Object data) {
        if (indexOf(data) >= 0) {
            return true;
        }
        return false;
    }

    boolean add(Object data) {
        if (data == null) {
            return false;
        }
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        numNodes++;
        return true;
    }

    Object get(int index) {
        Node temp = head;
        checkIndex(index);
        if (index == 0) {
            return head;
        } else {
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }

    Object getFirst() {
        return head;
    }

    Object getLast() {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }
}
