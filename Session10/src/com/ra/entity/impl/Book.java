package com.ra.entity.impl;

import com.ra.entity.IBook;
import com.ra.exception.BookInputException;
import com.ra.service.impl.BookService;

import java.io.Serializable;
import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Book implements IBook, Serializable {
    private int bookId;
    private String name;
    private float importPrice;
    private  float exportPrice;
    private  String author;
    private Date created = new Date();
    private String description;

    public Book() {
    }

    public Book(int bookId, String name, float importPrice, float exportPrice, String author, String description) {
        this.bookId = bookId;
        this.name = name;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.description = description;
    }

    public int getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public Date getCreated() {
        return created;
    }

    public String getDescription() {
        return description;
    }

    public void setBookId() {
        BookService bookService = new BookService();
        int maxId = 0;
        for (Book b: bookService.findAll()) {
            if(b.getBookId() > maxId){
                maxId = b.getBookId();
            }
        }
        this.bookId = ++maxId ;
    }

    public void setName(String name) throws Exception {
        if(name == null || name.length() != 4){
            throw new BookInputException("Tên sách bao gồm 4 kí tự!");
        }
        if(!name.startsWith("B")){
            throw new BookInputException("Tên sách bắt đầu là chữ B");
        }
        BookService bookService = new BookService();
        for (Book b: bookService.findAll()) {
            if(b.getName().equals(name)){
                throw new BookInputException("Tên sách đã tồn tại");
            }
        }
        this.name = name;
    }

    public void setImportPrice(float importPrice) throws Exception{
        if(importPrice <= 0){
            throw new BookInputException("Giá phập phải lớn hơn 0");
        }
        this.importPrice = importPrice;
    }

    public void setExportPrice(float exportPrice) throws Exception {
        if(exportPrice <= importPrice){
            throw new BookInputException("Giá bán phải lớn hơn giá nhập " + importPrice);
        }
        this.exportPrice = exportPrice;
    }

    public void setAuthor(String author) throws Exception{
        if(author==null || author.length()<6 || author.length()>50){
            throw new BookInputException("Tác giả có từ 6 đến 50");
        }
        this.author = author;
    }

    public void setDescription(String description) throws Exception{
        if(description ==null|| description.length()>500 ){
            throw new BookInputException("Mô tả không quá 500 kí tự");
        }
        this.description = description;
    }

    @Override
    public void inputData(Scanner scanner) {
        boolean invalid = true;
        do{
            try{
                System.out.print("Nhập tên sách:");
                setName(scanner.nextLine());
                invalid = false;
            }catch (Exception e){
                System.err.println(e.getMessage());
                invalid = true;
            }

        }while (invalid);
        do{
            try{
                System.out.print("Giá nhập:");
                setImportPrice(Float.parseFloat(scanner.nextLine()));
                invalid = false;
            }catch (Exception e){
                System.err.println(e.getMessage());
                invalid = true;
            }

        }while (invalid);
        do{
            try{
                System.out.print("Giá bán:");
                setExportPrice(Float.parseFloat(scanner.nextLine()));
                invalid = false;
            }catch (Exception e){
                System.err.println(e.getMessage());
                invalid = true;
            }

        }while (invalid);
        do{
            try{
                System.out.print("Nhập tác giả:");
                setAuthor(scanner.nextLine());
                invalid = false;
            }catch (Exception e){
                System.err.println(e.getMessage());
                invalid = true;
            }

        }while (invalid);
        do{
            try{
                System.out.print("Nhập mô tả: ");
                setDescription(scanner.nextLine());
                invalid = false;
            }catch (Exception e){
                System.err.println(e.getMessage());
                invalid = true;
            }

        }while (invalid);
        setBookId();
    }

    @Override
    public void displayData() {
        SimpleDateFormat fmd = new SimpleDateFormat("dd/MM/yyyy");
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        System.out.println("Mã sách: " + this.bookId);
        System.out.println("Tên sách: " + this.name);
        System.out.println("Giá nhập: " + vn.format(this.importPrice));
        System.out.println("Giá bán: " + vn.format(this.exportPrice));
        System.out.println("Tác giả: " + this.author);
        System.out.println("Mô tả: " + this.description);
        System.out.println("Ngày tạo: " + fmd.format(this.created));
    }
}
