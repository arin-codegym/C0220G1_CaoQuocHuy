package CauTrucDuLieuVaGiaiThuatCoBan.BTArrayList;

public class MyArrayListTest {
    public static void main(String[] args) {

        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("huy",0);
        myArrayList.add("hai",1);
        myArrayList.add("hau",2);
        myArrayList.add("hau",3);
        myArrayList.add("hau",4);
        myArrayList.add("hau",5);
        myArrayList.add("huy",6);

        System.out.println(myArrayList.size);
        System.out.println(myArrayList.elements.length);
        myArrayList.display();
    }
}
