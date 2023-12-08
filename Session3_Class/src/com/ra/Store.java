package com.ra;

import java.util.Arrays;


public class Store {
//    Product {
//        String id;
//        String name;
//        double price;
//        double discount;
//        double slaePrice;
//
//        Product() {} // constructor ko tham số
//        Product(id, name, price, discount) {} // constructor có tham số
//        // Get/Set
//        calculateSalePrice() {} // Tính giá bán cho sản phẩm
//    }
//    Dựa trên class Product trong BTVN buổi trước, phát triển tiếp ứng dụng
//            Tạo class Store {
//        Product[] products;
//
//        void add(Product p) {} // Thêm sản phẩm vào mảng products
//        Product findId(String id) {} // Tìm kiếm sản phẩm trong mảng products
//        boolean sort() {} // Sắp xếp các sản phẩm trong mảng products theo tên từ A-Z
//        void show() {} // Hiển thị toàn bộ dữ liệu sản phẩm đã được thêm trong mảng products
//    }
//    Viết chương trình Java kiểm tra các phương thức của class Sotre
    Product [] products;

    public void add(Product p){
        this.products = Arrays.copyOf(this.products== null ?new Product[1] : this.products, (this.products != null ? this.products.length : 0) +1);
        this.products[this.products.length-1] = p;
    }
    public  void sortProductList(){
        Arrays.sort(this.products, (a,b) -> a.getName().compareTo(b.getName()));
    }
    public Product findId(String id){
//        int index = Arrays.binarySearch(this.products,new Product(id,"",0,0,0));
//        if(index>0){
//            return this.products[index];
//        }
//        return new Product();
        for (int i = 0; i < this.products.length; i++) {
            if(this.products[i].getId()== id){
                return this.products[i];
            }
        }
        return new Product();
    }
    public void show(){
        for (int i = 0; i < this.products.length; i++) {
            System.out.print("\nSản phẩm thứ "+(i+1)+": " + this.products[i].getName());
        }
    }
}
