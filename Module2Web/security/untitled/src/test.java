import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        //Date date = nhanVien.getNgay_sinh();
        Date date = new Date(2000, Calendar.JULY,10,3,0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
        sdf.format(date);
        int daynow = LocalDate.now().getDayOfMonth();
        System.out.println(daynow);
        int monthnow = LocalDate.now().getMonthValue();
        int yearnow = LocalDate.now().getYear();
        int day = LocalDate.parse(sdf.format(date)).getDayOfMonth();
        int month = LocalDate.parse(sdf.format(date)).getMonthValue();
        int year = LocalDate.parse(sdf.format(date)).getYear();
        int age = yearnow - year;
    }
}
