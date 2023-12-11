package library.book;

import library.author.Author;
import library.author.AuthorList;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class BookList {
    private Book[] books;
    private final int defaultElement = 10;
    private  int index =0;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    public BookList(){
        books = new Book[defaultElement];
    }

    /**
     * Hàm thêm mới sách vào danh sách
     * @param book sách cần thêm vào
     * @return
     */
    public boolean add(Book book){
        if(findId(book.getId())==null){
            if(index == defaultElement)
                books = Arrays.copyOf(books, books.length + defaultElement);
            this.books[index++] = book;
            return true;
        }
        return false;
    }

    /**
     * Hàm tìm sách thông qua id của sách
     * @param id id sách cần tìm
     * @return
     */
    public Book findId(String id){
        if(index !=0){
            for (int i = 0; i <= index; i++) {
                if (Objects.equals(books[i].getId(), id)) {
                    return books[i];
                }
            }
        }
        return null;
    }

    /**
     * Hàm tìm sách theo tiêu đề
     * @param title Tiêu đề sách cần tìm
     * @return
     */
    public Book findByTitle(String title){
        if(index !=0){
            for (int i = 0; i <= index; i++){
                if (Objects.equals(books[i].getTitle().toUpperCase(), title.toUpperCase())) {
                    return books[i];
                }
            }
        }
        return null;
    }

    /**
     * Hàm tìm kiếm sách qua tác gải của sách
     * @param aut tác giả tìm kiếm
     * @return danh sách sách có tác giả
     */
    public Book[] findByAuthor(Author aut){
        Book[] result = new Book[0];
        if(index !=0){
            for (int i = 0; i <= index; i++) {
                if (Objects.equals(books[i].getAuthor().getName().toUpperCase(), aut.getName().toUpperCase())) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = books[i];
                }
            }
        }
        return result;
    }

    /**
     * Hàm xóa sách khỏi danh sách sách
     * @param book sách cần xóa
     * @return true là xóa thành công, false xóa không thành công
     */
    public boolean remove(Book book){
        if(index !=0){
            Book[] newBooks = new Book[index-1];
            if(findIndex(book.getId()) !=-1) {
                for (int i = 0,k=0; i <= index; i++) {
                    if (Objects.equals(books[i].getId(), book.getId())) {
                        continue;
                    }
                    newBooks[k++] = books[i];
                }
                books = newBooks;
                return true;
            }
        }
        return false;
    }

    /**
     * Hàm tìm kiếm vị trí sách trong danh sách sách thông qua id của sách
     * @param id id sách cần tìm
     * @return
     */
    public int findIndex(String id){
        if(index !=0){
            for (int i = 0; i <= index; i++) {
                if(Objects.equals(books[i].getId(), id)){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Hàm trả về số lượng sách trong danh sách
     * @return
     */
    public int size(){
        return index;
    }

    /**
     * Hàm thay đổi sách
     * @param id id sách cần thay đổi
     * @param scanner Giá trị nhập vào
     * @param authorList Danh sách tác giả
     * @return true thay đổi thành công, false thay đổi không thành công
     */
    public boolean edit(String id, Scanner scanner, AuthorList authorList) {
        if (index !=0){
            Book editBook = findId(id);
            if(editBook != null){
                System.out.println("Tiêu đề sách hiện tại: " + editBook.getTitle());
                System.out.print("Nhập tiêu đề sách mới: ");
                editBook.setTitle(scanner.nextLine());
                System.out.println("Tác giả hiện tại: " + editBook.getAuthor().getName());
                System.out.print("Nhập tên tác giả mới: ");
                String authorName = scanner.nextLine();
                Author newAuthor = authorList.findName(authorName);
                if(newAuthor == null){
                    System.out.println("Không có tác giả này!");
                    return false;
                }
                editBook.setAuthor(newAuthor);
                System.out.println("Giá hiện tại: " + editBook.getPrice());
                System.out.println("Nhập giá mới: ");
                editBook.setPrice(Double.parseDouble(scanner.nextLine()));
                return true;
            }
        }
        return false;
    }
    /**
     * Hàm nhập vào sách mới
     * @param scanner Giá trị nhập vào
     * @param authorList Danh sách tác giả
     * @return trả về sách nhập vào || null
     */
    public Book input(Scanner scanner, AuthorList authorList) {
        Book book = new Book();
        System.out.println("Nhập thông tin sách: ");
        System.out.print("\nNhập Id: ");
        book.setId(scanner.nextLine());
        System.out.print("\nNhập Title sách: ");
        book.setTitle(scanner.nextLine());
        System.out.print("\nNhập Id Tác giả: ");
        String idAuthor = scanner.nextLine();
        if(authorList.findId(idAuthor) !=null){
            book.setAuthor(authorList.findId(idAuthor));
        }else {
            System.out.println("Không có tác giả này!");
            return null;
        }
        System.out.print("\nNhập Giá: ");
        book.setPrice(Double.parseDouble(scanner.nextLine()));
        return book;
    }

    /**
     * Hàm in ra danh sách trong danh sách
     * @param books Danh sách cần in ra
     */
    public void output(Book[] books) {
        if(books.length !=0){
            System.out.printf("\n|%s|%s|%s|%s|",centerString(10,"ID sách"),centerString(20,"Title"),centerString(20,"Tác giả"),centerString(20,"Giá"));
            for (int i = 0; i < books.length; i++) {
                System.out.printf("\n|%s|%s|%s|%20s|",centerString(10,books[i].getId()),centerString(20,books[i].getTitle()),centerString(20,books[i].getAuthor().getName() ),books[i].getPrice());
            }
            System.out.println();
        }

    }

    /**
     * Hàm in toàn bộ danh sách sách
     */
    public void print() {
        if(index !=0){
            System.out.printf("\n|%s|%s|%s|%s|",centerString(10,"ID sách"),centerString(20,"Title"),centerString(20,"Tác giả"),centerString(20,"Giá"));
            for (int i = 0; i <= index; i++) {
                System.out.printf("\n|%s|%s|%s|%20s|",centerString(10,books[i].getId()),centerString(20,books[i].getTitle()),centerString(20,books[i].getAuthor().getName() ),books[i].getPrice());
            }
            System.out.println();
        }

    }
    /**
     * Hàm viết căn giữa
     * @param width Số lượng ký tự
     * @param s chuỗi cần căn giữa
     * @return trả về chuỗi đã căn giữa
     */
    public  String centerString (int width, String s) {
        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

}
