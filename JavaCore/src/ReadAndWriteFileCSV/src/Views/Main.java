package ReadAndWriteFileCSV.src.Views;

import CaseStudy.Commons.FuncGeneric;
import ReadAndWriteFileCSV.src.Commons.FuncFileCSV;
import ReadAndWriteFileCSV.src.Models.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        displayMainMenu();
    }

    private static ArrayList<Student> studentArrayList = new ArrayList<Student>();

    public static void displayMainMenu() {
        System.out.println("choose:\n" + "1.Add new student.\n" +
                "2.Show information student.\n" +
                "2.Delete information Student.\n" +
                "4.Edit information student." +
                "5.Exit.");
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                addNewStudent();
                break;
            case "2":
                showInformationStudent();
                break;
            case "3":
                deleteStudent();
                break;
            case "4":
                editStudent();
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("loi nhap lai");
                scanner.nextLine();
                displayMainMenu();
        }
    }


    private static void addNewStudent() {
        studentArrayList = FuncFileCSV.getFileCSVToListStudent();
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Enter id:");
        student.setId(scanner.nextLine());
        System.out.println("Enter name");
        student.setName(scanner.nextLine());
        System.out.println("Enter grade");
        student.setGrade(scanner.nextLine());
        System.out.println("Enter address");
        student.setAddress(scanner.nextLine());
        studentArrayList.add(student);
        FuncFileCSV.writeStudentToFileCSV(studentArrayList);
        System.out.println("add new student complete!Enter to continue...");
        scanner.nextLine();
        displayMainMenu();
    }

    private static void showInformationStudent() {
        getAllInformationStudents();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter to continue...");
        scanner.nextLine();
        displayMainMenu();
    }

    private static void getAllInformationStudents() {
        studentArrayList = FuncFileCSV.getFileCSVToListStudent();
        for (Student student : studentArrayList
        ) {
            System.out.println("----------------------");
            System.out.println("Id:" + student.getId());
            System.out.println("Name:" + student.getName());
            System.out.println("Grade:" + student.getGrade());
            System.out.println("Address:" + student.getAddress());
            System.out.println("----------------------");
        }
    }

    private static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        getAllInformationStudents();
        System.out.println("Please enter id student you want delete information:");
        String chooseDelete = scanner.nextLine();
        for (int i = 0; i < studentArrayList.size(); i++) {
            if (studentArrayList.get(i).getId().equals(chooseDelete)) {
                studentArrayList.remove(i);
                FuncFileCSV.writeStudentToFileCSV(studentArrayList);
                System.out.println("delete Complete!!!");
                break;
            }
        }
    }

    private static void editStudent() {
        Scanner sc = new Scanner(System.in);
        getAllInformationStudents();
        System.out.println("please enter id student you want edit information:");
        String chooseEdit = sc.nextLine();
        for (int i = 0; i < studentArrayList.size(); i++) {
            if (studentArrayList.get(i).getId().equals(chooseEdit)) {
                System.out.println("1" + studentArrayList.get(i).getId());
                System.out.println("2" + studentArrayList.get(i).getName());
                System.out.println("3" + studentArrayList.get(i).getGrade());
                System.out.println("4" + studentArrayList.get(i).getAddress());
                System.out.println("please choose property of student you want edit:");
                String chooseProperty = sc.nextLine();
                System.out.println("Please enter value you want change:");
                String valueProperty=sc.nextLine();
                switch (chooseProperty) {
                    case "1":
                        studentArrayList.get(i).setId(valueProperty);
                        break;
                    case "2":
                        studentArrayList.get(i).setName(valueProperty);
                        break;
                    case "3":
                        studentArrayList.get(i).setGrade(valueProperty);
                        break;
                    case "4":
                        studentArrayList.get(i).setAddress(valueProperty);
                        break;
                }
                System.out.println("Edit complete!!!");
                System.out.println("Enter to continue...");
                sc.nextLine();
                displayMainMenu();
                FuncFileCSV.writeStudentToFileCSV(studentArrayList);
                break;
            }
        }
    }
}
