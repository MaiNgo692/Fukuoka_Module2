package com.ra.assignment;

public class Student implements BaseEntity {
    String id;
    String name;
    String className;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public boolean checkId(Object id) {
        boolean check = id.equals(this.id);
        return check;
    }

    @Override
    public void input() {

    }

    @Override
    public void show() {
        System.out.println("Id: "+this.id);
        System.out.println("Name: "+this.name);
        System.out.println("Class name: "+ this.className);
    }

    @Override
    public boolean checkName(Object name) {
        boolean check = name.equals(this.name);
        return check;
    }

    @Override
    public boolean checkClasName(Object className) {
        boolean check = className.equals(this.className);
        return check;
    }
}
