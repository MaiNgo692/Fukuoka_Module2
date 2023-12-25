package com.ra.practive;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        int count = 0;
        do{
            count++;
            Student st = new Student();
            System.out.println("Nhập vào thông tin học sinh thứ " + count+" :");
            System.out.print("Nhập vào Id:");
            st.setId(Integer.parseInt(sc.nextLine()));
            System.out.print("\nNhập vào họ:");
            st.setFirstName(sc.nextLine());
            System.out.print("\nNhập vào tên:");
            st.setLastName(sc.nextLine());
            System.out.print("\nNhập vào giới tính:");
            st.setGender(sc.nextLine()=="nam"?true:false);

            students.add(st);
        }while (count< 5);
        Set<String> firstName = new HashSet<>();
        students.forEach(st->{
            firstName.add(st.getFirstName());
        });
//        Map<String, List<Student>>
        for (String fi:firstName) {
            System.out.println(fi);
            students.forEach(student -> {
                if(student.getFirstName().equals(fi)){
                    student.print();
                }
            });
        }
    }
}
