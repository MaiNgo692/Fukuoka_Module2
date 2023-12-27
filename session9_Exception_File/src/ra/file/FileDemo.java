package ra.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FileDemo {
    public static void main(String[] args) {
        List<Student> listStudents = new ArrayList<>();

        Student st1= new Student("SV001","Nguyên văn A", 20);
        Student st2= new Student("SV002","Nguyên văn B", 25);
        Student st3= new Student("SV003","Nguyên văn C", 22);

        listStudents.add(st1);
        listStudents.add(st2);
        listStudents.add(st3);

    }
    public static void writeDataToFile(List<Student> listStudents){
//        Khởi tạo đối tượng file
        File file = new File("demo.txt");


    }
}
