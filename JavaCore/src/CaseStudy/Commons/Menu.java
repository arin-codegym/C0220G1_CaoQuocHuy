package CaseStudy.Commons;

public class Menu {
    public static void displayMenuMain(){
        System.out.println("________________________________Main Menu___________________________");
        System.out.println("\n1.Add New Services." +
                "\n2.Show Services." +
                "\n3.Add New Customer" +
                "\n4.Show Information Customer" +
                "\n5.Add New Booking:" +
                "\n6.Show Information Employee" +
                "\n7.Booking MovieTicket 4D " +
                "\n8.Find Employee" +
                "\n9.Exit" + "\n" +
                "\nPlease choose:");
    }




    public static void displayMenuAddNewService(){
        System.out.println("________________");
        System.out.println("\n1. Add New Villa" +
                "\n2. Add New House" +
                "\n3. Add New Room" +
                "\n4. Back to menu" +
                "\nExit."
        );
        System.out.println("Please select one function below:");
    }
    public static void displayMenuShowServices(){
        System.out.println("__________" +
                "\n1. Show All Villa" +
                "\n2. Show All House" +
                "\n3. Show All Room" +
                "\n4.Show All Villa Not Duplicate" +
                "\n5.Show All House Not Duplicate" +
                "\n6.Show All Room Not Duplicate" +
                "\n7. Back to menu" +
                "\n8. Exit"
        );
        System.out.println("Please select one function below:");
    }
    public static void displayMenuBooking(){
        System.out.println("__________" +
                "\n1. Booking villa" +
                "\n2. Booking House" +
                "\n3. Booking Room"

        );
        System.out.println("Please select one function below:");

    }
    public static void displayMenuBookingMovieTicket4D(){
        System.out.println("_____Booking movie ticket 4D menu_____" +
                "\n1. Booking movie ticket" +
                "\n2. Show customer booking movie ticket" +
                "\n3.Exit");
        System.out.println("Please select one function below:");
    }

    public  static void displayMenuBackToMain(){
        System.out.println("_______________Enter to continue___________________");
        ScannerUtils.scanner.nextLine();
    }

}
