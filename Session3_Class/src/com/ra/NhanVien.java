package com.ra;

public class NhanVien {
    // Thuộc tính
    private String id;
    private String name;

    //Constructor hàm khởi tạo
    public NhanVien(){

    }
    public NhanVien(String id, String name){
        this.id = id;
        this.name = name;
    }

    //Getter: Lấy dữ liệu từ các fields private
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    //Setter: Truyền dữ liệu vào các fields private
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    //Behaviors Hành vi
    public void hello(){
        System.out.println("Xin chào các bạn!");
    }
}
