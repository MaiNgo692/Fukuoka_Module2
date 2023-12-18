package com.ra.assignment;

public class Program {
    public static void main(String[] args) {
        Manager students = new Manager();
        Manager employees = new Manager();

        Student st = new Student();
        st.setId("SV01");
        st.setName("Ha");
        st.setClassName("RA/FUKUOKA-JV230929");

        Student st1 = new Student();
        st1.setId("SV02");
        st1.setName("Mai");
        st1.setClassName("RA/FUKUOKA-JV230929");
        students.add(st);
        students.add(st1);

//        students.findId("SV01").show();
//        students.findFirst("name","Mai").show();
        students.findFirst("className","RA/FUKUOKA-JV230929").show();
    }
}
