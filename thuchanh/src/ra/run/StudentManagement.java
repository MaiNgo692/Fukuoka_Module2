package ra.run;

import ra.entity.IStudentManagement;
import ra.entity.Student;
import ra.entity.StudentClass;

import java.util.*;

public class StudentManagement {

    public static List<StudentClass> listClass = new ArrayList<>();
    public  static  List<Student> listStudents = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**************QUẢN LÝ HỌC VIỆN***************");
            System.out.println("1.Quản lý lớp");
            System.out.println("2.Quản lý sinh viên");
            System.out.println("3.Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    displayMenuClass(scanner);
                    break;
                case 2:
                    displayMenuStudent(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn từ 1-3");
            }
        }while (true);
    }
    public static void displayMenuClass(Scanner scanner){
        boolean isExist = true;

        do{
            System.out.println("**************QUẢN LÝ LỚP***************");
            System.out.println("1. Thêm mới lớp học");
            System.out.println("2. Cập nhật thông tin lớp học");
            System.out.println("3. Hiển thị thông tin lớp học");
            System.out.println("4. Thống kê các lớp học đang hoạt động");
            System.out.println("5. Tìm kiếm lớp học theo tên lớp học");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    inputListClass(scanner);
                    break;
                case 2:
                    updateClass(scanner);
                    break;
                case 3:
                    displayListClass();
                    break;
                case 4:
                    staticClassActive();
                    break;
                case 5:
                    searchClassByName(scanner);
                    break;
                case 6:
                    isExist = false;
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1-6");
            }
        }while (isExist);
    }

    public static void inputListClass(Scanner scanner){
        System.out.println("Nhập vào số lớp cần nhập thông tin:");
        int numberOfClass = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfClass; i++) {
            StudentClass studentClass = new StudentClass();
            studentClass.inputData(scanner);
            listClass.add(studentClass);
        }
    }
    public static void updateClass(Scanner scanner){
        System.out.println("Nhập vào mã lớp cần cập nhật thông tin:");
        String classIdUpdate = scanner.nextLine();
        int indexUpdate = getIndexByClassId(classIdUpdate);
        if(indexUpdate>=0){
            listClass.get(indexUpdate).inputClassName(scanner);
            listClass.get(indexUpdate).inputDescription(scanner);
            listClass.get(indexUpdate).inputClassStatus(scanner);
            System.out.println("Đã cập nhật xong thông tin lớp " + classIdUpdate);
        }else {
            System.out.printf("Lớp %s không tìm thấy, vui lòng nhập lại\n", classIdUpdate);
        }

    }

    public static int getIndexByClassId(String classId){
        for (int i = 0; i < listClass.size(); i++) {
            if(listClass.get(i).getClassId().equals(classId)){
                return i;
            }
        }
        return -1;
    }
    public static void displayListClass(){
        for (StudentClass stClass: listClass) {
            stClass.displayData();
        }
    }
    public static void staticClassActive(){
        int cntClass = 0;
        for (StudentClass stClass: listClass) {
            if(stClass.isClassStatus() == 1){
                cntClass ++;
            }
        }
        System.out.printf("Có %d lớp đang hoạt động\n",cntClass);
    }
    public static void searchClassByName(Scanner scanner){
        System.out.println("Nhập tên lớp cần tìm:");
        String className = scanner.nextLine();
        int cntClass = 0;
        for (StudentClass stClass: listClass) {
            if(stClass.getClassName().toLowerCase().contains(className.toLowerCase())){
                stClass.displayData();
                cntClass++;
            }
        }
        System.out.printf("Tìm thấy %d lớp có chứa %s\n",cntClass,className);
    }
    public static void displayMenuStudent(Scanner scanner){
        boolean isExist = true;

        do{
            System.out.println("**************QUẢN LÝ SINH VIÊN***************");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Cập nhật thông tin sinh viên");
            System.out.println("3. Hiển thị thông tin sinh viên");
            System.out.println("4. Tính điểm trung bình");
            System.out.println("5. Xếp loại sinh viên");
            System.out.println("6. Sắp xếp sinh viên theo điểm trung bình tăng dần");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8. Thống kê số sinh viên đạt loại giỏi, khá, trung bình");
            System.out.println("9. Thống kê sinh viên pass qua các môn học");
            System.out.println("10. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    inputListStudent(scanner);
                    break;
                case 2:
                    updateStudent(scanner);
                    break;
                case 3:
                    displayListStudent();
                    break;
                case 4:
                    calAvgListMark();
                    break;
                case 5:
                    calListGPA();
                    break;
                case 6:
                    sortStudentByMark();
                    break;
                case 7:
                    searchStudentByName(scanner);
                    break;
                case 8:
                    staticStudentByGPA();
                    break;
                case 9:
                    staticStudentPass();
                    break;
                case 10:
                    isExist = false;
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1-10");
            }
        }while (isExist);
    }
    public static void inputListStudent(Scanner scanner){
        System.out.println("Nhập số sinh viên cần nhập thông tin:");
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStudents; i++) {
            Student student = new Student();
            student.inputData(scanner);
            listStudents.add(student);
        }
    }
    public static void updateStudent(Scanner scanner){
        System.out.println("Nhập vào mã sinh viên cần cập nhật:");
        String studentIdUpdate = scanner.nextLine();
        int indexUpdate = getIndexByStudentId(studentIdUpdate);
        if(indexUpdate>=0){
            listStudents.get(indexUpdate).inputStudentName(scanner);
            listStudents.get(indexUpdate).inputStudentAge(scanner);
            listStudents.get(indexUpdate).inputStudentSex(scanner);
            listStudents.get(indexUpdate).inputClassId(scanner);
            listStudents.get(indexUpdate).inputMark(scanner,"Javascript");
            listStudents.get(indexUpdate).inputMark(scanner,"Java Core");
            listStudents.get(indexUpdate).inputMark(scanner,"Java Web");
            listStudents.get(indexUpdate).inputStatus(scanner);
            System.out.println("Cập nhập xong thông tin sinh viên");
        }else {
            System.out.println("Không tìm thấy mã sinh viên " + studentIdUpdate);
        }
    }
    public static int getIndexByStudentId(String studentId){
        for (int i = 0; i < listStudents.size(); i++) {
            if(listStudents.get(i).getStudentId().equals(studentId)){
                return i;
            }
        }
        return -1;
    }
    public static void displayListStudent(){
       listStudents.forEach(student -> student.displayData());
    }
    public static void calAvgListMark(){
        listStudents.forEach(student -> student.calAvgMark());
    }
    public static void calListGPA(){
        listStudents.forEach(student -> student.getGPAByAvgMark());
    }
    public static void sortStudentByMark(){
        Collections.sort(listStudents, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getAvgMark() > o2.getAvgMark()){
                    return 1;
                }else if(o1.getAvgMark() == o2.getAvgMark()){
                    return 0;
                }else {
                    return -1;
                }
            }
        });
    }
    public static void searchStudentByName(Scanner scanner){
        System.out.println("Nhập vào tên sinh viên cần tìm:");
        String studentName = scanner.nextLine();
        int cntStudent = 0;
        for (Student st: listStudents) {
            if(st.getStudentName().toLowerCase().contains(studentName.toLowerCase())){
                st.displayData();
                cntStudent++;
            }
        }
        System.out.printf("Tìm thấy %d sinh viên có tên chứa %s\n", cntStudent,studentName);
    }
    public static void staticStudentByGPA(){
        int numberOfWeak=0;
        int numberOfAvenge =0;
        int numberOfNormal=0;
        int numberOfGood =0;
        for (Student st: listStudents) {
            switch (st.getGpa()){
                case "Yếu":
                    numberOfWeak++;
                    break;
                case "Trung bình":
                    numberOfAvenge++;
                    break;
                case "Khá":
                    numberOfNormal++;
                    break;
                case "Giỏi":
                    numberOfGood++;
                    break;
            }
        }
        System.out.printf("Giỏi: %d - Khá: %d - Trung bình: %d - Yếu: %d",numberOfGood,numberOfNormal,numberOfAvenge,numberOfWeak);
    }

    public static void staticStudentPass(){
        int numberOfPass=0;
        for (Student st: listStudents) {
            if(st.getAvgMark() >= IStudentManagement.MARK_PASS){
                numberOfPass++;
            }
        }
        System.out.printf("Có %d học sinh Pass\n",numberOfPass);
    }
}
