package CaseStudy.Commons;

import CaseStudy.Model.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.MappingStrategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeSet;

import static CaseStudy.Commons.FuncWriteAndReadFileCSV.*;
import static CaseStudy.Controller.MainController.backMainMenu;

public class FuncGeneric {
    //the delimiter to use for separating entries
    private static final char DEFAULT_SEPARATOR = ',';
    // the character to use for quoted elements
    private static final char DEFAULT_QUOTE = '"';
    private static final int NUMBER_OF_LINE_SKIP = 1;

    public enum EntityType {
        VILLA,
        HOUSE,
        ROOM,
        CUSTOMER,
        EMPLOYEE

    }
    public static <E> void displayList(ArrayList<E> list){
        int i = 1;
        System.out.println("_______________List___________________");
        for (E item:list){
            System.out.println("NO."+i);
            if (item instanceof Villa){
                ((Villa) item).showInfo();
            }else if (item instanceof House){
                ((House) item).showInfo();
            }else if (item instanceof Room){
                ((Room) item).showInfo();
            }
        }
        i++;
        System.out.println("______________________________________");
    }


    public static <E> ArrayList<E> getListFromCSV(EntityType entityType) {
        String csvPath = "";
        String[] headerRecord;
        switch (entityType) {
            case VILLA:
                csvPath = pathVilla;
                headerRecord = headerRecordVilla;
                break;
            case HOUSE:
                csvPath = pathHouse;
                headerRecord = headerRecordHouse;
                break;
            case ROOM:
                csvPath = pathRoom;
                headerRecord = headerRecordRoom;
                break;
            case CUSTOMER:
                csvPath = pathCustomer;
                headerRecord = headerRecordCustomer;
                break;
            case EMPLOYEE:
                csvPath = pathEmployee;
                headerRecord = headerRecordEmployee;
                break;
            default:
                throw new IllegalStateException("Unexpected value" + entityType);
        }
        Path path = Paths.get(csvPath);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(csvPath);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ColumnPositionMappingStrategy<E> strategy = new ColumnPositionMappingStrategy<>();
        switch (entityType) {
            case VILLA:
                strategy.setType((Class<? extends E>) Villa.class);
                break;
            case HOUSE:
                strategy.setType((Class<? extends E>) House.class);
                break;
            case ROOM:
                strategy.setType((Class<? extends E>) Room.class);
                break;
            case CUSTOMER:
                strategy.setType((Class<? extends E>) Customer.class);
                break;
            case EMPLOYEE:
                strategy.setType((Class<? extends E>) Employee.class);
                break;
            default:

        }
        strategy.setColumnMapping(headerRecord);
        CsvToBean<E> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<E>(new FileReader(csvPath)).withMappingStrategy(strategy).withSeparator(DEFAULT_SEPARATOR).withQuoteChar(DEFAULT_QUOTE).withSkipLines(NUMBER_OF_LINE_SKIP).withIgnoreLeadingWhiteSpace(true).build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return (ArrayList<E>) csvToBean.parse();
    }
    public static void showAllNamNotDuplicate(EntityType entityType){
        String csvPath= "";
        switch (entityType){
            case VILLA:
                csvPath=pathVilla;
                break;
            case HOUSE:
                csvPath=pathHouse;
                break;
            case ROOM:
                csvPath=pathRoom;
                break;
        }
        Path path=Paths.get(csvPath);
        if (!Files.exists(path)){
            System.out.println("__File csv path does not Exits!");
            backMainMenu();
        }
        TreeSet<String> treeSet = FuncWriteAndReadFileCSV.getAllNameServiceFromCSV(csvPath);
        System.out.println("_____List Name Service Not Duplicate");
        for (String str :treeSet){
            System.out.println(str);
            System.out.println("_____________");
        }
        backMainMenu();
    }

}
