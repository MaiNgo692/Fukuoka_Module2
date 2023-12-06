package com.ra;

import java.util.Arrays;
import java.util.Scanner;

public class Store {
    /**
     * Tạo lớp Product(id, name, priceIn, discount, priceOut).
     * Viết chương trình java. Nhập vào danh sách 5 sản phẩm.
     * Hiển thị thông tin sản phẩm theo giá bán (priceOut) giảm dần.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int select;
        Product[] products = new Product[0];
        do {
            System.out.println("Hãy nhập lựa chọn của bạn:");
            System.out.println("1.Nhập thông tin danh sách sản phẩm.");
            System.out.println("2.Tính tiền từng sản phẩm trong danh sách ");
            System.out.println("3.In ra danh sách sản phảm theo thứ tự giá tăng dần");
            System.out.println("4.Thoát");
            select = Integer.parseInt(sc.nextLine());
            switch (select){
                case 1:
                    products = enterProductList(sc);
                    break;
                case 2:
                    for (int i = 0; i < products.length; i++) {
                        products[i].calculateSalePrice();
                    }
                    break;
                case 3:
                    sortProductList(products);
                    printProductList(products);
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + select);
            }
        } while (select != 4);



    }
    static Product[] enterProductList(Scanner sc){
        System.out.print("Hãy nhập số lượng sản phẩm:");
        int size =Integer.parseInt(sc.nextLine());
        Product[] products = new Product[size];
        for (int i = 0; i < size; i++) {
            Product p = new Product();
            System.out.print("Nhập id: ");
            p.setId(sc.nextLine());
            System.out.print("\nNhập tên: ");
            p.setName(sc.nextLine());
            System.out.print("\nNhập giá: ");
            p.setPrice(Double.parseDouble(sc.nextLine()));
            System.out.print("\nNhập discount: ");
            p.setDiscount(Double.parseDouble(sc.nextLine()));
            products[i] = p;
            System.out.println();
        }
        return products;
    }
    static void sortProductList(Product[] products){
        Arrays.sort(products, (a, b) -> {
            return (int) (a.getSalePrice() - b.getSalePrice());
        });
    }
    static void printProductList(Product[] products){
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].getName());
            System.out.println(products[i].getSalePrice());
            System.out.println("------------");
        }
    }
}
