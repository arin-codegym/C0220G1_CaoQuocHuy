package ReadAndWriteFileCSV.src.Commons;

import CaseStudy.Commons.FuncGeneric;
import ReadAndWriteFileCSV.src.Models.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuncFileCSV {
    private static final String COMMA_DELIMITER =",";
    private static final String NEW_LINE_SEPARATOR ="\n";
    // header file csv student kieu nhu table
    private static final String FILE_HEADER_STUDENT ="id,name,grade,address";
    private static final String PATH_STUDENT="src/Data/Student.csv";

    /**
     *
     * @param studentArrayList
     */
    public static void writeStudentToFileCSV(ArrayList<Student> studentArrayList){
        FileWriter fileWriter=null;
        try{
            fileWriter = new FileWriter(PATH_STUDENT);
            fileWriter.append(FILE_HEADER_STUDENT);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Student student :studentArrayList
                 ) {
                fileWriter.append(student.getId());
                //id
                fileWriter.append(COMMA_DELIMITER);
                //id,
                fileWriter.append(student.getName());
                //id,Huy
                fileWriter.append(COMMA_DELIMITER);
                //id,Huy,
                fileWriter.append(student.getGrade());
                //id,Huy,12
                fileWriter.append(COMMA_DELIMITER);
                //id,Huy,12,
                fileWriter.append(student.getAddress());
                //id,Huy,12,Quang Nam
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        }catch (Exception ex){
            System.out.println("Error in vscFileWriter !!!");
        }finally {
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception ex){
                System.out.println("Error when flush or close");
            }
        }
    }
    /*
    PT đọc file để tránh cài đè mất dữ liệu nghĩa là vẫn đề nhưng đem theo dữ liệu mưới gồm sữ liệu cũ
     */
    public static ArrayList<Student> getFileCSVToListStudent(){
        BufferedReader bufferedReader=null;
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        //chú ý 1 tao duong dan tranh file csv khong ton tai
        Path path = Paths.get(PATH_STUDENT);
        if (!Files.exists(path)){
            try{
                Writer writer = new FileWriter(PATH_STUDENT);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        // kêt thúc chú ý 1
        //-------------------------------------------------
        try{
            // tao dòng
            String line;
            // tao 1 đối tượng bufferedReader để đọc dữ liệu file csv  từ đường dẫn được truyền vào
            bufferedReader=new BufferedReader(new FileReader(PATH_STUDENT));
            // chạy while để đọc từng dòng từ đối tường bufferedReader chứa toàn bộ dừ liệu được đọc từ đường dãn ở trên
            // bằng null thì không làm
            while ((line=bufferedReader.readLine())!=null){
                //tạo mảng để tách chuỗi ra tạo thành 1 cái mảng và tách theo regex là dấu phẩy
                String[] splitData= line.split(",");
                // bỏ đi dong đầu tiên chuaws dữ liệu không cần thiêt là nam,grade,address
                if (splitData[0].equals("id")){
                    continue;
                }
                Student student = new Student();
                student.setId(splitData[0]);
                student.setName(splitData[1]);
                student.setGrade(splitData[2]);
                student.setAddress(splitData[3]);
                studentArrayList.add(student);
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                bufferedReader.close();
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return studentArrayList;
    }


}
