package CaseStudy.Controller;

import CaseStudy.Commons.FuncGeneric;
import CaseStudy.Commons.FuncWriteAndReadFileCSV;
import CaseStudy.Commons.ScannerUtils;
import CaseStudy.Model.Customer;
import CaseStudy.Model.House;
import CaseStudy.Model.Room;
import CaseStudy.Model.Villa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


import static CaseStudy.Commons.FuncGeneric.displayList;
import static CaseStudy.Commons.Menu.displayMenuBooking;
import static CaseStudy.Commons.Menu.displayMenuBookingMovieTicket4D;
import static CaseStudy.Controller.MainController.backMainMenu;

public class BookingController {
    private static Queue<Customer> customerQueueBookingTicket = new LinkedList<>();





    //add new booking
    public static void addNewBooking() {
        ArrayList<Customer> customerArrayList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.CUSTOMER);
        displayList(customerArrayList);
        System.out.println("____Choose one customer to booking_______");
        Customer customer = new Customer();
        customer = customerArrayList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
        displayMenuBooking();
        processMenuBooking(customer);

        //get list customer from csv
        ArrayList<Customer> customerArrayList1 = FuncWriteAndReadFileCSV.getBookingFromCSV();

        //add customer to list
        customerArrayList.add(customer);

        //write to csv
        FuncWriteAndReadFileCSV.writeBookingToFileCsv(customerArrayList);
        System.out.println("_____add booking for:" + customer.getName_customer() + "Successfully!!!");
        backMainMenu();
    }

    public static void bookingMovieTicket4D() {
        displayMenuBookingMovieTicket4D();
        processMenuBookingMovieTicket4D();
    }

    private static void processMenuBooking(Customer customer) {
        switch (ScannerUtils.scanner.nextLine()) {
            case "1":
                ArrayList<Villa> villaArrayList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.VILLA);
                displayList(villaArrayList);
                System.out.println("----Choose villa Booking:");
                Villa villa = villaArrayList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
                customer.setServices(villa);
                break;
            case "2":
                ArrayList<House> houseArrayList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.HOUSE);
                displayList(houseArrayList);
                System.out.println("----Choose house Booking:");
                House house = houseArrayList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
                customer.setServices(house);
                break;
            case "3":
                ArrayList<Room> roomArrayList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.ROOM);
                displayList(roomArrayList);
                System.out.println("----Choose room Booking:");
                Room room = roomArrayList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
                customer.setServices(room);
                break;
            default:
                backMainMenu();
                break;

        }
    }

    private static void processMenuBookingMovieTicket4D() {
        switch (ScannerUtils.scanner.nextLine()) {
            case "1":
                addBookingMovieTicket4D();
                break;
            case "2":
                showBookingMovieTicket();
                break;
            case "3":
                System.exit(0);
            default:
                System.out.println("Error!!!backing to menu");
                backMainMenu();
        }
    }


    public static void addBookingMovieTicket4D() {
        //lựa chon customer booking ticket
        try {
            ArrayList<Customer> customerArrayList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.CUSTOMER);
            displayList(customerArrayList);
            System.out.println("____choose customer want booking:");
            Customer customer = customerArrayList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
            customerQueueBookingTicket.add(customer);
            System.out.println("Add Booking for:" + customer.getName_customer() + "Successfully!!!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Customer to booking movie ticket 4D not exist!!!try again");
            addBookingMovieTicket4D();
        }
        backMainMenu();
    }

    private static void showBookingMovieTicket() {
        int i = 1;
        System.out.println("----------List---------------");
        for (Customer customer:customerQueueBookingTicket){
            System.out.println("NO: "+i);
            customer.showInfo();
            i++;
            System.out.println("-----------------------------------------");
        }
        backMainMenu();
    }
}
