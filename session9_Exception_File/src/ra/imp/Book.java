package ra.imp;

import ra.IBook;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Book implements IBook, Serializable {
    private int bookId; //tự sinh (max + 1)
    private String bookName; //duy nhất, gồm 4 ký tụ, bắt đầu là B
    private float importPrice;// có giá trị lớn hơn 0
    private float exportPrice;// có giá trị lớn hơn importPrice
    private String author;// có từ 6 đến 50 ký tự
    private String created;// có định dạng dd/MM/yyyy
    private String description;// tối đa 500 ký tự

    public Book() {
    }

    public Book(int bookId, String bookName, float importPrice, float exportPrice, String author, String created, String description) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.created = created;
        this.description = description;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {

        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    @Override
    public void inputData(Scanner scanner) {
        //Tự động nhập bookId
        inputBookId();
        //Nhập tên sách
        inputBookName(scanner);
        //Nhập importPrice
        inputImportPrice(scanner);
        //Nhập exportPrice
        inputExportPrice(scanner);
        //Nhập author
        inputAuthor(scanner);
        //Nhập ngày tạo
        inputCreatDate();
        //Nhập description
        inputDescription(scanner);
    }
    public void inputBookId(){
        if(BookRun.listBook.size()==0){
            this.bookId = 1;
        }else {
            int max = BookRun.listBook.get(0).getBookId();
            for (Book book: BookRun.listBook) {
                if(max< book.getBookId()){
                    max = book.getBookId();
                }
            }
            this.bookId = max + 1;
        }
    }

    public void inputBookName(Scanner scanner){
        System.out.println("Nhập tên sách:");
            do{
                String bookName = scanner.nextLine();
                if(BookRun.listBook != null){
                    for (Book book: BookRun.listBook) {
                        if(book.getBookName().toLowerCase().equals(bookName.toLowerCase())){
                            System.out.println("Tên sách là bị trùng, vui lòng nhập lại");
                        }
                    }
                }
                if(bookName.startsWith("B")&& bookName.length()==4){
                    this.bookName = bookName;
                    break;
                }else {
                    System.out.println("Tên sách duy nhất gồm 4 ký tự bắt đầu là B, vui lòng nhập lại");
                }
            }while (true);
    }
    public void inputImportPrice(Scanner scanner){
        System.out.println("Nhập importPrice của sách:");
        float importPrice;
        do{
            try {
                importPrice = Float.parseFloat(scanner.nextLine());
                if(importPrice <=0){
                    System.out.println("importPrice có giá trị lớn hơn 0, vui lòng nhập lại");
                }else {
                    this.importPrice = importPrice;
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("importPrice có định dạng số thực, vui lòng nhập lại");
            }
        }while (true);
    }
    public void inputExportPrice(Scanner scanner){
        System.out.println("Nhập exportPrice của sách:");
        float exportPrice;
        do{
            try {
                exportPrice = Float.parseFloat(scanner.nextLine());
                if(exportPrice <= this.importPrice){
                    System.out.printf("exportPrice có giá trị lớn hơn %d, vui lòng nhập lại\n",this.importPrice);
                }else {
                    this.exportPrice = exportPrice;
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("exportPrice có định dạng số thực, vui lòng nhập lại");
            }
        }while (true);
    }
    public void inputAuthor(Scanner scanner){
        System.out.println("Nhập Author của sách:");
        String author;
        do{
                author = scanner.nextLine();
                if(author.length() < 6 || author.length()>50){
                    System.out.println("Author có từ 6-50 ký tự, vui lòng nhập lại");
                }else {
                    this.author = author;
                    break;
                }
        }while (true);
    }
    public void inputCreatDate(){
        Date myDate = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        this.created = formatDate.format(myDate);
    }
    public void inputDescription(Scanner scanner){
        System.out.println("Nhập mô tả của sách:");
        String description = scanner.nextLine();
        do {
            if(description.length()>500){
                System.out.println("Mô tả của sách tối đa 500 ký tự, vui lòng nhập lại");
            }
            else {
                this.description = description;
                break;
            }
        }while (true);

    }
    @Override
    public void displayData() {
        System.out.printf("Id: %d - Name: %s - ImportPrice:%f - ExportPrice: %f -Author: %s - Creat: %s - Description: %s ",
                this.bookId,this.bookName,this.importPrice,this.exportPrice,this.author,this.created,this.description);
    }
}
