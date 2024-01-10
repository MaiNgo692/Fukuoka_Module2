package com.ra.service;

import com.ra.model.Computer;
import com.ra.model.Product;

public interface IComputerService {
    void add(Computer computer);
    Computer findById(String id);
    boolean turnOn(String id);
    void turnOffPay(String id);
    void displayAll();
}
