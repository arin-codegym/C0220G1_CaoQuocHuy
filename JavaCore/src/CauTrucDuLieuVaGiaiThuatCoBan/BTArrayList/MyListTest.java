package CauTrucDuLieuVaGiaiThuatCoBan.BTArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList myList = new MyList();
        try {
            myList.add(0, 3);
            myList.add(1, 2);
            myList.add(2, 3);
            myList.add(3, 8);
            myList.add(4);

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        myList.display();
        myList.remove(1);
        System.out.println("======");
        myList.display();
        MyList myList2 = myList.clone();
        System.out.println(myList.indexOf(null));
//        myList2.add(0, 5);
//        myList2.display();

    }
}
