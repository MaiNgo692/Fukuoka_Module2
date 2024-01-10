package com.ra;

import com.ra.entity.impl.Book;
import com.ra.service.impl.BookService;

import java.util.Scanner;

public class BookRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService();
        bookService.load();
        do{
            System.out.println("************-----MENU-----*************");
            System.out.println("1. Nhập thông tin sách");
            System.out.println("2. Hiển thị thông tin sách");
            System.out.println("3. Cập nhật thông tin theo mã sách");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("6. Thống kê sách theo khoảng giá");
            System.out.println("7. Tìm kiếm sách theo tên tác giả");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Nhập thông tin sách:");
                    Book book =  new Book();
                    book.inputData(scanner);
                    bookService.addBook(book);
                    break;
                case 2:
                    System.out.println("Hiển thị thông tin sách");
                    bookService.findAll().forEach(Book::displayData);
                    break;
                case 3:
                    System.out.println("Nhập id sách cần cập nhật");
                    int id =  Integer.parseInt(scanner.nextLine());
                    Book updateBook =  bookService.findId(id);
                    if(updateBook != null){
                        updateBook.inputData(scanner);
                    }else {
                        System.out.println("Không tìm thấy sách có id= "+ id);
                    }
                    break;
                case 4:
                    System.out.println("Nhập id sách cần xóa:");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    bookService.remove(deleteId);
                    break;
                case 5:
                    System.out.println("Sắp xếp theo giá bán tăng dần");
                    for (Book b:bookService.sortByPrice()) {
                        b.displayData();
                    }
                    break;
                case 6:
                    System.out.println("Tìm kiếm theo khoảng giá");
                    System.out.printf("Từ: ");
                    float from = Float.parseFloat(scanner.nextLine());
                    System.out.print("Đến: ");
                    float to = Float.parseFloat(scanner.nextLine());
                    for (Book b:bookService.findPriceBetween(from,to)) {
                        b.displayData();
                    }
                    break;
                case 7:
                    System.out.println("Nhập tên tác giả sách cần tìm");
                    String author = scanner.nextLine();
                    for (Book b:bookService.findByAuthor(author)) {
                        b.displayData();
                    }
                    break;
                case 8:
                    bookService.save();
                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Hãy chọn từ 1 đến 8");
                    break;
            }
        }while (true);
    }
}
