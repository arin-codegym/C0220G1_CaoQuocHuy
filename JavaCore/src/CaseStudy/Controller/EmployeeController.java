package CaseStudy.Controller;

import CaseStudy.Commons.FuncGeneric;
import CaseStudy.Commons.ScannerUtils;
import CaseStudy.Data.Resume;
import CaseStudy.Model.Employee;

import java.util.*;

import static CaseStudy.Controller.MainController.backMainMenu;

public class EmployeeController {
    public static void showInformationEmployees() {
        ArrayList<Employee> employeeArrayList= FuncGeneric.getListFromCSV(FuncGeneric.EntityType.EMPLOYEE);
        Map<String,Employee> map = new HashMap<>();
        for (Employee employee: employeeArrayList){
            map.put(employee.getId(),employee);
        }
        displayMap(map);
        backMainMenu();
    }
    public static void displayMap(Map<String, Employee> map){
        for (Map.Entry m : map.entrySet()){
            System.out.println("Key: "+m.getKey()+"\n"+m.getValue().toString());
        }
    }
    public static void findInForEmployee(){
        Stack<Employee> employeeStack= Resume.getAllEmployee();
        System.out.println("Enter key of employee: ");
        String inputSearch= ScannerUtils.scanner.nextLine();
        try{
            while (true){
                boolean foundById = employeeStack.peek().getId().contains(inputSearch);
                if (!foundById){
                    employeeStack.pop();
                }else {
                    System.out.println("---------Founded employee below: ");
                    System.out.println(employeeStack.peek().toString());
                    break;
                }
            }

        }catch (EmptyStackException e){
            System.out.println("key invalid,please try again!!!");
            findInForEmployee();
        }
        backMainMenu();
    }
}
