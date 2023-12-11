package library;

import library.author.Author;
import library.author.AuthorList;
import library.book.Book;
import library.book.BookList;

import java.util.Scanner;

public class Library {
    /**
     * Viết chương trình Java quản lý thư viện. Quản lý 2 loại thông tin về sách và tác giả
     * Menu chính
     *      1. Quản lý tác giả
     *      2. Quản lý sách
     *      3. Thoát
     * Khi chọn menu 1. Quản lý tác giả
     *      1. Thêm tác giả
     *      2. Hiển thị tác giả
     *      3. Cập nhật thông tin tác giả (theo id)
     *      4. Xóa tác giả (Không xóa tác giả có đã sách)
     *      5. Quay lại (quay trở về menu chính)
     * Khi chọn menu 2. Quản lý sách
     *      1. Thêm sách
     *      2. Tìm kiếm sách theo tiêu đề
     *      3. Tìm kiếm sách theo tên tác giả
     *      4. Cập nhật sách (theo id)
     *      5. Quay lại (Quay về menu chính)
     */
    static int selection;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookList bookList = inputBook();
        AuthorList authorList = inputAuthor();
        do{
            System.out.println("Menu chính: ");
            System.out.println("1. Quản lý tác giả");
            System.out.println("2. Quản lý sách");
            System.out.println("3. Thoát");
            selection = Integer.parseInt(sc.nextLine());
            switch (selection){
                case 1:
                    authorManagement(sc,authorList,bookList);
                    break;
                case 2:
                    bookManagement(sc,authorList,bookList);
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình!");
                    break;
                default:
                    System.out.println("Hãy chọn từ 1 đến 3!");
            }
        }while (selection !=3);
    }
    /**
     * Hàm quản lý tác giả:
     * @param sc Giá trị nhập vào
     * @param authorList Danh sách tác giả
     * @param bookList Danh sách sách đang có
     */
    static void authorManagement(Scanner sc,AuthorList authorList,BookList bookList ){
        do {
            System.out.println("Menu quản lý tác giả: ");
            System.out.println("1. Thêm tác giả");
            System.out.println("2. Hiển thị tác giả");
            System.out.println("3. Cập nhật thông tin tác giả(theo Id)");
            System.out.println("4. Xóa tác giả(Không xóa tác giả đã có sách)");
            System.out.println("5. Quay lại (quay trở về menu chính)");
            selection = Integer.parseInt(sc.nextLine());
            switch (selection){
                case 1:
                    Author newAuthor = authorList.input(sc);
                    authorList.add(newAuthor);
                    break;
                case 2:
                    authorList.output();
                    break;
                case 3:
                    System.out.print("\nNhập Id tác giả cần cập nhật: ");
                    String editIdAuthor = sc.nextLine();
                    Author editAuthor = authorList.findId(editIdAuthor);
                    authorList.edit(editAuthor,sc);
                    break;
                case 4:
                    System.out.print("\nNhập Id tác giả cần xóa: ");
                    String deleteIdAuthor = sc.nextLine();
                    Author deleteAuthor = authorList.findId(deleteIdAuthor);
                    authorList.remove(deleteAuthor,bookList);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Hãy chọn từ 1 đến 5!");
                    break;
            }
        }while (selection !=5);
    }

    /**
     * Hmaf quản lý sách:
     * @param sc - Giá trị nhập vào
     * @param authorList Danh sách tác giả
     * @param bookList Danh sách sách đang có
     */
    static void bookManagement(Scanner sc,AuthorList authorList,BookList bookList){
        do {
            System.out.println("Menu quản lý sách: ");
            System.out.println("1. Thêm sách");
            System.out.println("2. hiển thị sách");
            System.out.println("3. Tìm kiếm sách theo tiêu đè");
            System.out.println("4. Tìm kiếm sách theo tên tác giả");
            System.out.println("5. Cập nhật sách theo id");
            System.out.println("6. Quay lại (quay trở về menu chính)");
            selection = Integer.parseInt(sc.nextLine());
            switch (selection){
                case 1:
                    Book newBook = bookList.input(sc,authorList);
                    if(newBook!=null){
                        bookList.add(newBook);
                        System.out.println("Thêm sách thành công!");
                    }
                    break;
                case 2:
                    bookList.print();
                    break;
                case 3:
                    System.out.print("\nNhập tiêu đề cần tìm kiếm: ");
                    String searchTitle = sc.nextLine();
                    if(bookList.findByTitle(searchTitle) != null){
                        bookList.findByTitle(searchTitle).output();
                    }else {
                        System.out.println("\nKhông có kết quả! ");
                    }
                    break;
                case 4:
                    System.out.print("\nNhập tên tác giả của sách cần tìm kiếm: ");
                    String searchAuthor = sc.nextLine();
                    Author aut = authorList.findName(searchAuthor);
                    if(authorList.findName(searchAuthor) != null){
                        Book[] searchResult = bookList.findByAuthor(aut);
                        bookList.output(searchResult);
                    }else {
                        System.out.print("\nKhông có kết quả! ");
                    }
                    break;
                case 5:
                    System.out.print("\nNhập Id sách cần cập nhật: ");
                    String editIdBook = sc.nextLine();
                    if(bookList.edit(editIdBook,sc,authorList)){
                        System.out.println("Cập nhật sách thành công!");
                    }else {
                        System.out.println("Cập nhật sách không thành công!");
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Hãy chọn từ 1 đến 6!");
                    break;
            }
        }while (selection !=6);
    }

    /**
     * Hàm tạo danh sách sách ban đầu
     * @return
     */
    static BookList inputBook(){
        BookList bookList = new BookList();
        bookList.setIndex(4);
        AuthorList authorList = inputAuthor();
        Book[] books = new Book[5];
        books[0] = new Book("s01","HTML",authorList.getAuthors()[0],30000);
        books[1] = new Book("s02","CSS3",authorList.getAuthors()[1],30000);
        books[2] = new Book("s03","JAVA",authorList.getAuthors()[0],30000);
        books[3] = new Book("s04","SQL",authorList.getAuthors()[1],30000);
        books[4] = new Book("s05","Excel",authorList.getAuthors()[2],30000);
        bookList.setBooks(books);
        return bookList;
    }

    /**
     * Hàm tạo danh sách tác giả
     * @return
     */
    static AuthorList inputAuthor(){
        AuthorList authorList = new AuthorList();
        authorList.setIndex(4);
        Author[] authors = new Author[5];
        authors[0] = new Author("tg01","Mai","m@gmail.com","nữ",30);
        authors[1] = new Author("tg02","Ha","h@gmail.com","nam",39);
        authors[2] = new Author("tg03","Thuy","t@gmail.com","nữ",35);
        authors[3] = new Author("tg04","Trang","tr@gmail.com","nữ",32);
        authors[4] = new Author("tg05","Minh","min@gmail.com","nam",36);
        authorList.setAuthors(authors);
        return authorList;
    }
}
