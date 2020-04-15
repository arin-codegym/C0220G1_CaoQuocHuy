package CauTrucDuLieuVaGiaiThuatCoBan.BTLinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst("a");
        myLinkedList.addFirst("1");
        myLinkedList.add(1, "c");
        myLinkedList.addLast("last");
        myLinkedList.printList();
        myLinkedList.addLast("b");
        System.out.println("============");
        System.out.println("xoa " + myLinkedList.remove(3));
        myLinkedList.printList();
        System.out.println("======");
        MyLinkedList myLinkedList1 = myLinkedList.clone();
        myLinkedList1.printList();
        myLinkedList1.addLast("bb");
        System.out.println("=====");
        myLinkedList1.printList();
        System.out.println("===");
        System.out.println("=====");
        System.out.println(myLinkedList1.indexOf("a"));
    }
}
