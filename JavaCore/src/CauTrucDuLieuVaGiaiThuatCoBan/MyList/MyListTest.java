package CauTrucDuLieuVaGiaiThuatCoBan.MyList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> integerMyList = new MyList<Integer>();
        integerMyList.Size();
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(3);
        integerMyList.add(4);
        integerMyList.add(5);
        integerMyList.add(6);
        integerMyList.add(7);
        integerMyList.add(8);
        integerMyList.add(9);
        integerMyList.add(10);
        integerMyList.add(11);


        integerMyList.Size();
        integerMyList.length();
        System.out.println("element 4: " + integerMyList.get(4));
        System.out.println("element 1: " + integerMyList.get(1));
        System.out.println("element 2: " + integerMyList.get(2));
        System.out.println("element 7: " + integerMyList.get(11));
        integerMyList.get(-1);
        System.out.println("element 6: " + integerMyList.get(-1));
    }
}
