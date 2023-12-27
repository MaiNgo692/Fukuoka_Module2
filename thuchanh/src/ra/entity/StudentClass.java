package ra.entity;

import java.util.Scanner;

public class StudentClass implements IStudentManagement{
    private String classId;
    private String className;
    private String description;
    private  int classStatus;

    public StudentClass() {
    }

    public StudentClass(String classId, String className, String description, int classStatus) {
        this.classId = classId;
        this.className = className;
        this.description = description;
        this.classStatus = classStatus;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int isClassStatus() {
        return classStatus;
    }

    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        inputClassId(scanner);
        inputClassName(scanner);
        inputDescription(scanner);
        inputClassStatus(scanner);
    }
    public void inputClassId(Scanner scanner){
        System.out.println("Nhập vào mã lớp: ");
        do {
            this.classId = scanner.nextLine();
            if(this.classId.length() == 5 && this.classId.startsWith("J")){
                break;
            }else {
                System.out.println("Mã lớp phải gồm 5 ký tự, bắt đầu bằng J, vui lòng nhập lại");
            }
        }while (true);
    }
    public void inputClassName(Scanner scanner){
        System.out.println("Nhập vào Tên lớp: ");
        do {
            this.className = scanner.nextLine();
            if(this.className.length() <=10){
                break;
            }else {
                System.out.println("Tên lớp tối đa 10 ký tự, vui lòng nhập lại");
            }
        }while (true);
    }
    public void inputDescription(Scanner scanner){
        System.out.println("Nhập vào mô tả lớp: ");
            this.description = scanner.nextLine();
    }
    public void inputClassStatus(Scanner scanner) {
        System.out.println("Chọn trạng thái của lớp: ");
        do {
            System.out.println("0. Chờ lớp");
            System.out.println("1. Chờ lớp");
            System.out.println("2. Chờ lớp");
            System.out.println("3. Chờ lớp");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            if(choice<=0 && choice<=3){
                this.classStatus = choice;
                break;
            }else {
                System.out.println("Vui lòng chọn từ 0-3");
            }
        } while (true);
    }
    @Override
    public void displayData() {
        String status;
        switch (this.classStatus){
            case 0:
                status = "Chờ lóp";
                break;
            case 1:
                status = "Hoạt động";
                break;
            case 2:
                status = "Tạm dừng";
                break;
            default:
                status = "Kết thúc";
        }
        System.out.printf("Mã lớp: %s - Tên lớp: %s- Mô tả: %s - Trạng thái: %s",this.classId,this.className,this.description,status);
    }
}
