package CaseStudy.Controller;

import CaseStudy.Commons.FuncGeneric;

import CaseStudy.Commons.FuncValidation;
import CaseStudy.Commons.FuncWriteAndReadFileCSV;
import CaseStudy.Commons.ScannerUtils;
import CaseStudy.Model.House;
import CaseStudy.Model.Room;
import CaseStudy.Model.Services;
import CaseStudy.Model.Villa;
import java.util.ArrayList;
import static CaseStudy.Commons.FuncGeneric.displayList;
import static CaseStudy.Commons.Menu.*;
import static CaseStudy.Controller.MainController.backMainMenu;
import static CaseStudy.Controller.MainController.processMain;
import static ReadAndWriteFileCSV.src.Views.Main.displayMainMenu;

public class ServiceController {
    public static final String ENTER_SERVICE_ID = "Enter service ID:";
    public static final String INVALID_SERVICE_ID = "\n" +
            "168/5000\n" +
            "- Service code must be in the correct format: SVXX-YYYY, with YYYY are the numbers from 0-9, XX are:\n" +
            "- If it's Villa then XX will be VL\n" +
            "- If it's House then XX will be HO\n" +
            "- If Room, XX will be RO";
    public static final String ENTER_SERVICE_NAME = "Enter service name:";
    public static final String INVALID_SERVICE_NAME = "\n" +
            "73/5000\n" +
            "- Service name must capitalize first letter, the following characters are normal characters";
    public static final String ENTER_AREA_USED = "";
    public static final String INVALID_DOUBLE_NUMBER = "- Use area  must be a real number larger than 30m2";
    public static final String ENTER_RENTAL_COST = "Enter rental cost:";
    public static final String INVALID_RENTAL_COST = "- Rent cost must be positive";
    public static final String ENTER_MAX_NUMBER_OF_PEOPLE = "Enter max number of people";
    public static final String INVALID_MAX_PEOPLE = "- The maximum number of people must be> 0 and smaller than <20";
    public static final String ENTER_RENT_TYPE = "Enter rent type:";
    public static final String INVALID_RENT_TYPE = "Room type, Standard room for standardizing data like the service name";
    public static final String ENTER_ROOM_STANDARD = "Enter room standard";
    public static final String INVALID_ROOM_STANDARD = "Room type, Standard room for standardizing data like the service name";
    public static final String ENTER_AREA_POOL = "Enter area pool";
    public static final String INVALID_AREA_POOL = "\"- The maximum number of people must be> 0 and smaller than <20\"";
    public static final String ENTER_NUMBER_OF_FLOORS = "Enter number of floors";
    public static final String INVALID_NUMBER_OF_FLOORS = "- The number of floors must be a positive integer";
    public static final String ENTER_FREE_SERVICES = "Enter free services:";
    public static final String INVALID_FREE_SERVICES = "- The accompanying service must be values: massage, karaoke, food, drink, car";

    public static void addNewServices() {

        displayMenuAddNewService();
        processMenuAddNewService();

    }


    private static void processMenuAddNewService() {
        System.out.println("________________");
        System.out.println("\n1. Add New Villa" +
                "\n2. Add New House" +
                "\n3. Add New Room" +
                "\n4. Back to menu" +
                "\nExit."
        );
        switch (ScannerUtils.scanner.nextInt()) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("\nError!!!");
                displayMenuBackToMain();
        }
    }

    private static Services addNewService(Services services) {
        //set services ID
        services.setId(FuncValidation.getValidIdService(services, ENTER_SERVICE_ID, INVALID_SERVICE_NAME));

        //set services Name
        services.setName(FuncValidation.getValidName(ENTER_SERVICE_NAME, INVALID_SERVICE_NAME));

        //set Area user
        services.setAreaUsed(FuncValidation.getValidNumberDouble(ENTER_AREA_USED, INVALID_DOUBLE_NUMBER, 30.0));

        //set Rental Cost
        services.setRentalCosts(FuncValidation.getValidNumberDouble(ENTER_RENTAL_COST, INVALID_RENTAL_COST, 0.0));

        //set Max Number Of People
        services.setMaximumNumberOfPeople(FuncValidation.getValidNumberInteger(ENTER_MAX_NUMBER_OF_PEOPLE, INVALID_MAX_PEOPLE, 0, 20));

        //set rent type
        services.setTypeOfRent(FuncValidation.getValidName(ENTER_RENT_TYPE, INVALID_RENT_TYPE));

        return services;
    }

    private static void addNewRoom() {
        Services room = new Room();
        //Enter common property villa
        addNewService(room);

        //Enter free services
        ((Room) room).setFreeServiceIncluded(FuncValidation.getValidFreeServices(ENTER_FREE_SERVICES, INVALID_FREE_SERVICES));

        // get list room from CSV
        ArrayList<Room> roomArrayList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.ROOM);

        //add new room to list
        roomArrayList.add((Room) room);

        //write
        FuncWriteAndReadFileCSV.writeRoomToFileCSV(roomArrayList);
        System.out.println("Add Room" + room.getName() + "Successfully");
        backMainMenu();
    }

    private static void addNewHouse() {
        Services house = new House();
        //Enter common property villa
        addNewService(house);

        //Enter room standard
        ((House) house).setRoomStandard(FuncValidation.getValidName(ENTER_ROOM_STANDARD, INVALID_ROOM_STANDARD));

        //Enter description
        ((House) house).setDescriptionOfOtherAmenities(ScannerUtils.scanner.nextLine());


        //Enter Number of floors
        ((House) house).setNumberOfFloors(FuncValidation.getValidNumberInteger(ENTER_NUMBER_OF_FLOORS, INVALID_NUMBER_OF_FLOORS, 0));

        // get list villa from CSV
        ArrayList<House> houseArrayList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.HOUSE);

        // add house to list
        houseArrayList.add((House) house);

        //write
        FuncWriteAndReadFileCSV.writeHouseToFileCSV(houseArrayList);
        backMainMenu();
    }

    private static void addNewVilla() {
        Services villa = new Villa();
        //Enter common property villa
        addNewService(villa);

        //Enter room standard
        ((Villa) villa).setRoomStandard(FuncValidation.getValidName(ENTER_ROOM_STANDARD, INVALID_ROOM_STANDARD));

        //Enter description
        ((Villa) villa).setDescriptionOfOtherAmenities(ScannerUtils.scanner.nextLine());

        //Enter Area Pool
        ((Villa) villa).setPoolArea(FuncValidation.getValidNumberDouble(ENTER_AREA_USED, INVALID_AREA_POOL, 30.0));

        //Enter Number of floors
        ((Villa) villa).setNumberOfFloors(FuncValidation.getValidNumberInteger(ENTER_NUMBER_OF_FLOORS, INVALID_NUMBER_OF_FLOORS, 0));

        // get list villa from CSV
        ArrayList<Villa> villaArrayList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.VILLA);

        // add villa to list
        villaArrayList.add((Villa) villa);

        // write new csv
        FuncWriteAndReadFileCSV.writeVillaToFileCSV(villaArrayList);
        System.out.println("\nAdd Villa: " + villa.getName() + " Successfully!!!");
        backMainMenu();
    }


    public static void showServices() {
        displayMenuShowServices();
        processMenuShowServices();
    }

    private static void processMenuShowServices() {
        switch (ScannerUtils.scanner.nextInt()) {
            case 1:
                showVilla();
                break;
            case 2:
                showHouse();
                break;
            case 3:
                showRoom();
                break;
            case 4:
                showAllNameVilla();
                break;
            case 5:
                showAllNameHouse();
                break;
            case 6:
                showAllNameRoom();
                break;
            case 7:
                processMain();
                System.out.println("\n__________________________________________");
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("\nError!!!");
                backMainMenu();
                break;

        }
    }

    private static void showAllNameVilla() {
        FuncGeneric.showAllNamNotDuplicate(FuncGeneric.EntityType.VILLA);
    }

    private static void showAllNameHouse() {
        FuncGeneric.showAllNamNotDuplicate(FuncGeneric.EntityType.HOUSE);
    }

    private static void showAllNameRoom() {
        FuncGeneric.showAllNamNotDuplicate(FuncGeneric.EntityType.ROOM);
    }

    private static void showRoom() {
        ArrayList<Room> roomArrayList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.ROOM);
        displayList(roomArrayList);
        backMainMenu();
    }

    private static void showHouse() {
        ArrayList<House> houseArrayList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.HOUSE);
        displayList(houseArrayList);
        backMainMenu();
    }

    private static void showVilla() {
        ArrayList<Villa> villaArrayList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.VILLA);
        displayList(villaArrayList);
        backMainMenu();
    }




}
