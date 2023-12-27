package ra.entity;

import ra.run.StudentManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Student implements IStudentManagement{
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private String  classId;

    private ArrayList<Float> listMarkJavaScript;
    private ArrayList<Float> listMarkJavaCore;
    private  ArrayList<Float> listMarkJavaWeb;
    private float avgMark;
    private String gpa;
    private boolean studentStatus;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, boolean sex, String classId, ArrayList<Float> listMarkJavaScript, ArrayList<Float> listMarkJavaCore, ArrayList<Float> listMarkJavaWeb, boolean studentStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.classId = classId;
        this.listMarkJavaScript = listMarkJavaScript;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaWeb = listMarkJavaWeb;
        this.studentStatus = studentStatus;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public ArrayList<Float> getListMarkJavaScript() {
        return listMarkJavaScript;
    }

    public void setListMarkJavaScript(ArrayList<Float> listMarkJavaScript) {
        this.listMarkJavaScript = listMarkJavaScript;
    }

    public ArrayList<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(ArrayList<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public ArrayList<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(ArrayList<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    @Override
    public void inputData(Scanner scanner) {
        inputStudentId(scanner);
        inputStudentName(scanner);
        inputStudentAge(scanner);
        inputStudentSex(scanner);
        inputClassId(scanner);
        inputMark(scanner,"Javascript");
        inputMark(scanner,"Java Core");
        inputMark(scanner,"Java Web");
        inputStatus(scanner);
    }

    @Override
    public void displayData() {

    }
    public void inputStudentId(Scanner scanner){
        System.out.println("Nhập mã sinh viên:");
        do {
            String studentId = scanner.nextLine();
            if(studentId .length() ==6 && studentId.startsWith("S")){
                break;
            }else {
                System.out.println("Mã sinh viên phải gồm 6 ký tự, bắt đầu bằng S, vui lòng nhập lại");
            }
        }while (true);

    }
    public void inputStudentName(Scanner scanner){
        System.out.println("Nhập tên sinh viên:");
        do {
            String studentId = scanner.nextLine();
            if(studentId .length() >= 20 && studentId .length() <=50){
                break;
            }else {
                System.out.println("Tên sinh viên bao gồm 20-50 ký tự, vui lòng nhập lại");
            }
        }while (true);

    }
    public void inputStudentAge(Scanner scanner){
        System.out.println("Nhập tuổi sinh viên:");
        do {
            int age = Integer.parseInt(scanner.nextLine());
            if(age>=18){
                break;
            }else {
                System.out.println("Tuổi sinh viên lớn hơn hoặc bằng 18, vui lòng nhập lại");
            }
        }while (true);
    }
    public void inputStudentSex(Scanner scanner){
        System.out.println("Nhập giới tính sinh viên:");
        this.sex = Boolean.parseBoolean(scanner.nextLine());
    }
    public void inputClassId(Scanner scanner){
        System.out.println("Chọn lớp của sinh viên:");
        do {
            for (int i = 0; i < StudentManagement.listClass.size(); i++) {
                System.out.printf("%d.%s",(i+1),StudentManagement.listClass.get(i).getClassName());
            }
            System.out.print("Chọn lớp:");
            int choice = Integer.parseInt(scanner.nextLine());
            if(choice >0 && choice<= StudentManagement.listClass.size()){
                this.classId = StudentManagement.listClass.get(choice-1).getClassId();
                break;
            }else {
                System.err.printf("Vui lòng chọn từ 1-%d\n",StudentManagement.listClass.size());
            }
        }while (true);
    }
    public void inputMark(Scanner scanner, String subjectName){
        System.out.printf("Nhập vào điểm %s: \n", subjectName);
        switch (subjectName){
            case "Javascript":
                this.listMarkJavaScript.add(Float.parseFloat(scanner.nextLine()));
                break;
            case "Java Core":
                this.listMarkJavaCore.add(Float.parseFloat(scanner.nextLine()));
                break;
            case "Java Web":
                this.listMarkJavaWeb.add(Float.parseFloat(scanner.nextLine()));
                break;
        }
    }
    public void inputStatus(Scanner scanner){
        System.out.println("Nhập trạng thái sinh viên:");
        this.studentStatus = Boolean.parseBoolean(scanner.nextLine());
    }
    public void calAvgMark(){
        float avgMark = (listMarkJavaCore.get(listMarkJavaCore.size() - 1) + listMarkJavaScript.get(listMarkJavaScript.size() - 1) + listMarkJavaWeb.get(listMarkJavaWeb.size() - 1))/3;
        this.avgMark = avgMark;
    }

    public void getGPAByAvgMark(){
        String gpa;
        if(this.avgMark < 5){
            gpa ="Yếu";
        }else if(this.avgMark < 7){
            gpa = "Trung bình";
        }else if(this.avgMark < 9){
            gpa = "Khá";
        }else {
            gpa = "Giỏi";
        }
    }
}
