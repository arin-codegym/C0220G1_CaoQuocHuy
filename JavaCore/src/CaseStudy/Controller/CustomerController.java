package CaseStudy.Controller;

import CaseStudy.Commons.FuncGeneric;
import CaseStudy.Commons.FuncValidation;
import CaseStudy.Commons.FuncWriteAndReadFileCSV;
import CaseStudy.Commons.ScannerUtils;
import CaseStudy.Model.Customer;
import CaseStudy.Model.SortNameAndYear;

import java.util.ArrayList;

import static CaseStudy.Commons.FuncGeneric.displayList;
import static CaseStudy.Controller.MainController.backMainMenu;

public class CustomerController {

    public static final String ENTER_CUSTOMER_NAME = "Enter customer name:";
    public static final String INVALID_CUSTOMER_NAME = "\n" +
           " Name Customer must be in the first letter format and do not allow extra spaces.";
    public static final String ENTER_GENDER = "Enter gender:";
    public static final String INVALID_GENDER = "You must enter Male, Female or Unknown";
    public static final String ENTER_ID_CARD = "Enter your IdCard:";
    public static final String INVALID_ID_CARD = "Card Id must be 9 digits and in the format XXX XXX XXX";
    public static final String ENTER_EMAIL = "Enter your email:";
    public static final String INVALID_EMAIL = "49/5000\n" +
            "Email includes only @ and at least 1 sign.";
    public static final String ENTER_BIRTHDAY = "Enter your Birthday:";
    public static final String INVALID_BIRTHDAY = "The birth year must be> 1900 and 18 years smaller than the current year, in the correct format dd / mm / yyyy";

    // add new customer
    public static void addNewCustomer(){
        Customer customer=new Customer();
        //set name
        customer.setName_customer(FuncValidation.getValidCustomerName(ENTER_CUSTOMER_NAME,INVALID_CUSTOMER_NAME));

        //set birthday
        customer.setBirthday(FuncValidation.getValidBirthday(ENTER_BIRTHDAY,INVALID_BIRTHDAY));

        //set gender
        String gender=  FuncValidation.getValidGender(ENTER_GENDER,INVALID_GENDER);
        customer.setGender(Character.toUpperCase(gender.charAt(0))+gender.substring(1,gender.length()).toLowerCase());

        //set ID
        customer.setId_card(FuncValidation.getValidIdCard(ENTER_ID_CARD,INVALID_ID_CARD));

        //set phone
        System.out.println("Enter phone-number:");
        customer.setPhone_number(ScannerUtils.scanner.nextLine());

        //set email
        customer.setEmail(FuncValidation.getValidEmail(ENTER_EMAIL,INVALID_EMAIL));

        //set type
        System.out.println("Enter Type customer:");
        customer.setGuest_type(ScannerUtils.scanner.nextLine());

        //set address
        System.out.println("Enter Address Customer:");
        customer.setAddress(ScannerUtils.scanner.nextLine());


//-----------------------------------------------------------------//
        //get List customer from csv
        ArrayList<Customer> customerArrayList= FuncGeneric.getListFromCSV(FuncGeneric.EntityType.CUSTOMER);

        //add customer to list
        customerArrayList.add(customer);

        //Write File Customer.CSV
        FuncWriteAndReadFileCSV.writeCustomerToFileCsv(customerArrayList);
        System.out.println("\nAdd Customer: " + customer.getName_customer() + " Successfully !!!");
        backMainMenu();
    }

    //show information customer
    public static void showInformationCustomers(){
        ArrayList<Customer> customerArrayList=FuncGeneric.getListFromCSV(FuncGeneric.EntityType.CUSTOMER);

        //Sắp xếp theo thứ tự Alpha B theo tên,trường hợp trùng tên thì sắp xếp tăng dần theo năm sinh
        customerArrayList.sort(new SortNameAndYear());
        displayList(customerArrayList);
        backMainMenu();
    }
}

