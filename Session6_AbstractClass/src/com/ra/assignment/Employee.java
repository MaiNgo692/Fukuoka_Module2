package com.ra.assignment;

public class Employee implements BaseEntity{
    private String id;
    private String name;
    private double salary;

    @Override
    public boolean checkId(Object id) {
        return id.equals(this.id);
    }

    @Override
    public void input() {

    }

    @Override
    public void show() {

    }

    @Override
    public boolean checkName(Object name) {
        return false;
    }

    @Override
    public boolean checkClasName(Object className) {
        return false;
    }
}
