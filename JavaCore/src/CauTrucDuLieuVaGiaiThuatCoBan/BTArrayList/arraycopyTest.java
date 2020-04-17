package CauTrucDuLieuVaGiaiThuatCoBan.BTArrayList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class arraycopyTest {
    public static void main(String[] args) {
        int s[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int d[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int source_arr[], sourcePos, dest_arr[], destPos, len;
        source_arr = s;
        sourcePos = 2;
        dest_arr =Arrays.copyOf(s,s.length+1);
        System.out.println(dest_arr[10]);
        destPos = 3;
        len = 8;

        // Print elements of source
        System.out.print("source_array : ");
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }

        System.out.println("");

        System.out.println("sourcePos : " + sourcePos);

        // Print elements of source
        System.out.print("dest_array : ");
        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i] + " ");
        }
        System.out.println("");

        System.out.println("destPos : " + destPos);

        System.out.println("len : " + len);

        // Use of arraycopy() method
        System.arraycopy(source_arr, sourcePos, dest_arr,
                destPos, len);

        // Print elements of destination after
        System.out.print("final dest_array : ");
        for (int i = 0; i < dest_arr.length; i++) {
            System.out.print(dest_arr[i] + " ");
        }
    }
}
