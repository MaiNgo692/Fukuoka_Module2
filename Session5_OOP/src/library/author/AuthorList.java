package library.author;

import library.book.BookList;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class AuthorList {
    private Author[] authors;
    private final int defaultElement = 10;
    private  int index =0;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public AuthorList(){
        authors = new Author[defaultElement];
    }

    /**
     * Hàm thêm tác giả mới vào danh sách
     * @param aut tác giả cần thêm
     * @return  true thêm thành công, false thêm không thành công
     */
    public boolean add(Author aut){
            if(findId(aut.getId())==null){
                if(index == defaultElement) {
                    authors = Arrays.copyOf(authors, authors.length + defaultElement);
                }
                this.authors[index++] = aut;
                return true;
            }
        return false;
    }

    /**
     * Hàm tìm kiếm tác giả thông qua id của tác giả
     * @param id id tác giả cần tìm kiếm
     * @return tác giả có id || null
     */
    public Author findId(String id){
        if(index !=0) {
            for (int i = 0; i <= this.index; i++) {
                if (Objects.equals(authors[i].getId().toUpperCase(), id.toUpperCase())) {
                    return authors[i];
                }
            }
        }
        return null;
    }

    /**
     * Hàm tìm kiếm tác giả qua tên tác giả
     * @param name tên tác giả cần tìm kiếm
     * @return tác giả có tên giống tên tìm kiếm
     */
    public Author findName(String name){
        if(index != 0) {
            for (int i = 0; i <= this.index; i++) {
                if (Objects.equals(authors[i].getName().toUpperCase(), name.toUpperCase())) {
                    return authors[i];
                }
            }
        }
        return null;
    }

    /**
     * Hàm xóa tác giả khỏi danh sách
     * @param aut Tác giả cần xóa
     * @param books Danh sách sách hiện có
     * @return true xóa thành công , false xóa thất bại
     */
    public boolean remove(Author aut, BookList books){
        Author[] newAuthors = new Author[authors.length-1];
        for (int i = 0; i < books.getIndex(); i++) {
            if(Objects.equals(books.getBooks()[i].getAuthor().getId(), aut.getId())){
                System.out.println("Tác giả này có sách nên không thể xóa!");
                return false;
            }
        }
        if(findIndex(aut.getId()) !=-1 ) {
            for (int i = 0,k=0; i <= this.index; i++) {
                if (Objects.equals(authors[i].getId(), aut.getId())) {
                    continue;
                }
                newAuthors[k++] = authors[i];
            }
            authors = newAuthors;
            this.index--;
            System.out.println("Xóa thành công tác giả!");
            return true;
        }
        System.out.println("Xóa không thành công tác giả!");
        return false;
    }

    /**
     * Hàm tìm kiếm vị trí tác giả trong danh sách thông qia id của tác giả
     * @param id id tác giả cần tìm kiếm
     * @return >=0 trả về có giá trị, -1 không có tác giả
     */
    public int findIndex(String id){
        if(index !=0){
            for (int i = 0; i <= index; i++) {
                if(Objects.equals(authors[i].getId(), id)){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Hàm tìm kiếm số lượng tác giả trong danh sách
     * @return kích cỡ mảng
     */
    public int size(){
        return index;
    }

    /**
     * Hàm thay đổi thông tin tác giả
     * @param aut Tác giả cần thay đổi
     * @param scanner Thông tin nhập vào
     * @return true thay đổi thành công, false thay đổi không thành công
     */
    public boolean edit(Author aut, Scanner scanner) {
        Author editAuthor = findId(aut.getId());
        if(editAuthor != null){
            System.out.println("Tên tác giả cũ: "+ editAuthor.getName());
            System.out.print("Hãy nhập tên mới: ");
            editAuthor.setName(scanner.nextLine());
            System.out.println("Tuổi tác giả cũ: "+ editAuthor.getAge());
            System.out.print("Hãy nhập tuổi mới: ");
            editAuthor.setAge(Integer.parseInt(scanner.nextLine()));
            System.out.println("Email tác giả cũ: "+ editAuthor.getEmail());
            System.out.print("Hãy nhập Email mới: ");
            editAuthor.setEmail(scanner.nextLine());
            System.out.println("Giới tính tác giả cũ: "+ editAuthor.getGender());
            System.out.print("Hãy nhập giới tính mới: ");
            editAuthor.setGender(scanner.nextLine());
            return true;
        }
        System.out.println("Không có tác giả id "+aut.getId()+" trong danh sách!");
        return false;
    }

    /**
     * Hàm nhập vào thông tin tác giả
     * @param scanner nhập thông tin vào
     * @return
     */
    public Author input(Scanner scanner) {
        Author aut = new Author();
        System.out.println("Nhập thông tin tác giả:");
        System.out.print("\nNhập Id: ");
        aut.setId(scanner.nextLine());
        System.out.print("\nNhập Tên: ");
        aut.setName(scanner.nextLine());
        System.out.print("\nNhập Email: ");
        aut.setEmail(scanner.nextLine());
        System.out.print("\nNhập Giới tính: ");
        aut.setGender(scanner.nextLine());
        System.out.print("\nNhập Tuổi: ");
        aut.setAge(Integer.parseInt(scanner.nextLine()));
        return aut;
    }

    /**
     * Hàm in ra toàn bộ danh sách tác giả
     */
    public void output() {
        if(index !=0){
            System.out.printf("\n|%s|%s|%s|%s|%s|",centerString(10,"ID"),centerString(20,"Name"),centerString(20,"Email"),centerString(5,"Tuổi") ,centerString(10,"Giới Tính"));
            for (int i = 0; i <= index; i++) {
                System.out.printf("\n|%s|%s|%s|%5s|%10s|",centerString(10,authors[i].getId()),centerString(20,authors[i].getName()),centerString(20,authors[i].getEmail()),authors[i].getAge(),authors[i].getGender());
            }
        }
        System.out.println();
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
