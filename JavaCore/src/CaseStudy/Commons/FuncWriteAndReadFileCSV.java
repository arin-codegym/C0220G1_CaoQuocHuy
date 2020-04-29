package CaseStudy.Commons;

import CaseStudy.Model.Customer;
import CaseStudy.Model.House;
import CaseStudy.Model.Room;
import CaseStudy.Model.Villa;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class FuncWriteAndReadFileCSV {
    // path
    public static final String pathVilla = "src/Data/Villa.csv";
    public static final String pathHouse = "src/Data/House.csv";
    public static final String pathRoom = "src/Data/Room.csv";
    public static final String pathCustomer = "src/Data/Customer.csv";
    public static final String pathBooking = "src/Data/Booking.csv";
    public static final String pathEmployee = "src/Data/Employee.csv";


    // header
    public static String[] headerRecordVilla = new String[]{"id", "name", "area_used", "rental_costs", "maximum_number_of_people", "type_of_rent",
            "room_standard", "description_of_other_amenities", "number_of_floors", "pool_area"};

    public static String[] headerRecordHouse = new String[]{"id", "name", "area_used", "rental_costs", "maximum_number_of_people", "type_of_rent",
            "room_standard", "description_of_other_amenities", "number_of_floors"};

    public static String[] headerRecordRoom = new String[]{"id", "name", "area_used", "rental_costs", "maximum_number_of_people", "type_of_rent",
            "free_service_included"};

    public static String[] headerRecordCustomer = new String[]{"name_customer", "birthday", "gender", "id_card", "phone_number", "email",
            "guest_type", "address"};

    public static String[] headerRecordBooking = new String[]{"full_name", "birthday", "gender", "id_card", "phone_number", "email", "guest_type",
            "address", "id", "service_name", "area_user", "rental_costs", "max_people", "rent_type"};


    public static String[] headerRecordEmployee = new String[]{"id", "name", "age", "address"};

    public static void writeVillaToFileCSV(ArrayList<Villa> villaArrayList) {
        try (Writer writer = new FileWriter(pathVilla);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END)) {
            csvWriter.writeNext(headerRecordVilla);
            for (Villa villa : villaArrayList) {
                csvWriter.writeNext(new String[]{
                        villa.getId(),
                        villa.getName(),
                        String.valueOf(villa.getAreaUsed()),
                        String.valueOf(villa.getRentalCosts()),
                        String.valueOf(villa.getMaximumNumberOfPeople()),
                        String.valueOf(villa.getTypeOfRent()),
                        villa.getRoomStandard(),
                        villa.getDescriptionOfOtherAmenities(),
                        String.valueOf(villa.getNumberOfFloors()),
                        String.valueOf(villa.getPoolArea())
                });
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeHouseToFileCSV(ArrayList<House> arrayList) {
        try (Writer writer = new FileWriter(pathHouse);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.DEFAULT_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END)) {
            csvWriter.writeNext(headerRecordHouse);
            for (House house : arrayList) {
                csvWriter.writeNext(new String[]{
                        house.getId(),
                        house.getName(),
                        String.valueOf(house.getAreaUsed()),
                        String.valueOf(house.getRentalCosts()),
                        String.valueOf(house.getMaximumNumberOfPeople()),
                        house.getTypeOfRent(),
                        house.getRoomStandard(),
                        house.getDescriptionOfOtherAmenities(),
                        String.valueOf(house.getNumberOfFloors()),
                });
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeRoomToFileCSV(ArrayList<Room> arrayList) {
        try (Writer writer = new FileWriter(pathRoom);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.DEFAULT_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END)) {
            csvWriter.writeNext(headerRecordRoom);
            for (Room room : arrayList) {
                csvWriter.writeNext(new String[]{
                        room.getId(),
                        room.getName(),
                        String.valueOf(room.getAreaUsed()),
                        String.valueOf(room.getRentalCosts()),
                        String.valueOf(room.getMaximumNumberOfPeople()),
                        room.getTypeOfRent(),
                        room.getFreeServiceIncluded(),
                });
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static TreeSet<String> getAllNameServiceFromCSV(String path) {
        BufferedReader br = null;
        TreeSet<String> result = new TreeSet<>();
        try {
            String line;
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                if (getNameServicesFromFile(line).equals("serviceName")) {
                    continue;
                }
                result.add(getNameServicesFromFile(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
        //  result.descendingSet();
        return result;
    }

    private static String getNameServicesFromFile(String csvLine) {
        String name = "";
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            name = splitData[1];
        }
        return name;
    }
    //write customer
    public static void writeCustomerToFileCsv(ArrayList<Customer> customerArrayList){
        try(Writer writer = new FileWriter(pathCustomer);
            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);) {

            // add header to file
            csvWriter.writeNext(headerRecordCustomer);
            for (Customer customer : customerArrayList) {
                csvWriter.writeNext(new String[]
                        {customer.getName_customer(),
                                customer.getBirthday(),
                                customer.getGender(),
                                String.valueOf(customer.getId_card()),
                                String.valueOf(customer.getPhone_number()),
                                customer.getEmail(),
                                customer.getGuest_type(),
                                customer.getAddress(),
                        });
            }}
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    //write Booking to file CSV
    public static void writeBookingToFileCsv(ArrayList<Customer> customerArrayList) {
        try (Writer writer = new FileWriter(pathBooking);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {

            // add header to file
            csvWriter.writeNext(headerRecordBooking);
            for (Customer customer : customerArrayList) {
                csvWriter.writeNext(new String[]
                        {customer.getName_customer(),
                                customer.getBirthday(),
                                customer.getGender(),
                                String.valueOf(customer.getId_card()),
                                String.valueOf(customer.getPhone_number()),
                                customer.getEmail(),
                                customer.getGuest_type(),
                                customer.getAddress(),
                                String.valueOf(customer.getServices()),
                                customer.getServices().getName(),
                                String.valueOf(customer.getServices().getAreaUsed()),
                                String.valueOf(customer.getServices().getRentalCosts()),
                                String.valueOf(customer.getServices().getMaximumNumberOfPeople()),
                                customer.getServices().getTypeOfRent()
                        });
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    // get list booking from csv
    public static ArrayList<Customer> getBookingFromCSV() {
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        try (Reader reader = new FileReader(pathBooking);
             CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] line;
            csvReader.skip(1);
            while ((line=csvReader.readNext()) !=null){
                Customer customer=new Customer();
                Villa villa=new Villa();
                int pos =0;
                customer.setName_customer(line[pos++]);
                customer.setBirthday(line[pos++]);
                customer.setGender(line[pos++]);
                customer.setId_card((line[pos++]));
                customer.setPhone_number((line[pos++]));
                customer.setEmail(line[pos++]);
                customer.setAddress(line[pos++]);
                customer.setGuest_type(line[pos++]);

                villa.setId(line[pos++]);
                villa.setName(line[pos++]);
                villa.setAreaUsed(Double.parseDouble(line[pos++]));
                villa.setRentalCosts(Double.parseDouble(line[pos++]));
                villa.setMaximumNumberOfPeople(Integer.parseInt(line[pos++]));
                villa.setTypeOfRent(line[pos++]);
           customer.setServices(villa);
           customerArrayList.add(customer);
            }
                ;
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return customerArrayList;
    }
}


