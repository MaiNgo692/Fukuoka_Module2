package com.ra.service;

import com.ra.model.Computer;

import java.sql.Time;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ComputerService implements IComputerService{
    private List<Computer> computers = new ArrayList<>();

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

    @Override
    public void add(Computer computer) {
        computers.add(computer);
    }

    @Override
    public Computer findById(String id) {
        return computers.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public boolean turnOn(String id) {
        Computer computer = findById(id);
        if(computer != null){
            if(!computer.isStatus()){
                computer.setStatus(true);
                computer.setStart(new Date());
            }else {
                System.out.println("Máy đang được mở!");
            }
        }else {
            System.out.println("Không tìm thấy máy có id= " + id);
        }
        return false;
    }

    @Override
    public void turnOffPay(String id) {
        Computer computer = findById(id);
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        if(computer != null){
            if(computer.isStatus()){
                computer.setStatus(false);
                long useTime = new Date().getTime()/(1000*60*60)%24 - computer.getStart().getTime()/(1000*60*60)%24;
                System.out.println("Giá tiền: " + vn.format(useTime == 0 ? computer.getPrice(): useTime * computer.getPrice()));
            }else {
                System.out.println("Máy đang được mở!");
            }
        }else {
            System.out.println("Không tìm thấy máy có id= " + id);
        }
    }

    @Override
    public void displayAll() {
        computers.forEach(c -> System.out.println("Mã máy: "+c.getId() +" Trạng thái: "+ (c.isStatus()? "Đang có người dùng" : "Đang trống"))
        );
    }
}
