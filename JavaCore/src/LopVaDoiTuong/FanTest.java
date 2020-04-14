package LopVaDoiTuong;

public class FanTest {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.FAST);
        fan1.setColor("yellow");
        fan1.setRadius(10);
        fan1.setOn(true);
        System.out.println("FAN1: "+fan1.toString());
        Fan fan2 = new Fan();
        fan1.setSpeed(fan1.MEDIUM);
        fan1.setColor("bLUE");
        fan1.setRadius(5);
        fan1.setOn(false);
        System.out.println("FAN2: "+fan1.toString());
    }
}
