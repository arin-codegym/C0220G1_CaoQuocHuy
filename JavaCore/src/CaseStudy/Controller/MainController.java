package CaseStudy.Controller;


import CaseStudy.Commons.ScannerUtils;

import static CaseStudy.Commons.Menu.*;
import static CaseStudy.Controller.BookingController.addBookingMovieTicket4D;

import static CaseStudy.Controller.BookingController.addNewBooking;
import static CaseStudy.Controller.CustomerController.*;
import static CaseStudy.Controller.EmployeeController.findInForEmployee;
import static CaseStudy.Controller.EmployeeController.showInformationEmployees;
import static CaseStudy.Controller.ServiceController.addNewServices;
import static CaseStudy.Controller.ServiceController.showServices;

public class MainController {
    public static void processMain() {
        try {
           // displayMenuMain();
            processMenuMain();
        } catch (Exception e) {
            backMainMenu();
        }
    }


    public static void processMenuMain() {

        System.out.println("\n1.Add New Services." +
                "\n2.Show Services." +
                "\n3.Add New Customer" +
                "\n4.Show Information Customer" +
                "\n5.Add booking:" +
                "\n6.Show Information Employee" +
                "\n7.Booking MovieTicket 4D " +
                "\n8.Find Employee" +
                "\n9.Exit" + "\n" +
                "\nPlease choose:");
        switch (ScannerUtils.scanner.nextInt()) {
            case 1:
                addNewServices();
                break;
            case 2:
                showServices();
                break;
            case 3:
                addNewCustomer();
                break;
            case 4:
                showInformationCustomers();
            case 5:
                addNewBooking();
                break;
            case 6:
                showInformationEmployees();
                break;
            case 7:
                addBookingMovieTicket4D();
                break;
            case 8:
                findInForEmployee();
                break;
            case 9:
                System.exit(0);
            default:
                System.out.println("\nError!!!");
                backMainMenu();
        }
    }

    public static void backMainMenu() {
        displayMenuBackToMain();
        processMain();
    }


}
