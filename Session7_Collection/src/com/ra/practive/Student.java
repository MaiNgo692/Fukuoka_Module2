package com.ra.practive;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private boolean gender;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, boolean gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public void print(){
        System.out.printf("Họ và tên: %20s | Giới tính: %10s", this.firstName+" "+ this.lastName, this.gender?"Nam":"Nữ");
        System.out.println();
    }
}
