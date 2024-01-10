package com.ra.model;
// Sử dụng Stream API, lambda expression
// 1. Hiển ra danh sách các sp Model bắt đầu bằng "M"
// 2. Tìm kiếm sản phẩm theo Model (Model là duy nhất trong collection)
// 3. Lấy ra danh sách List<String> model sản phẩm
// 4. Kiểm tra xem trong collection có bất kỳ sản phẩm nào giá > 1000 không?
// 5. Đếm các sản phẩm có cùng mức giá
// VD: 1000: 2 sp//     2000: 3 sp//     3000: 1 sp
public class Product {
    private String id;
    private String model;
    private String name;
    private  double price;
    private boolean status;

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void display(){
        System.out.println("Mã sản phẩm: " + this.id);
        System.out.println("Mẫu: " + this.model);
        System.out.println("Tên sản phẩm: " + this.name);
        System.out.println("Giá: " +this.price);
        System.out.println("Trạng thái: " + this.status);
    }
}
