package ra.imp;

import java.io.*;
import java.util.*;

public class BookRun {
    static List<Book> listBook = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = true;
        if(readDataFromFile()!= null){
            listBook = readDataFromFile();
        }
        do {
            System.out.println("\n******************** MENU *************************");
            System.out.println("1. Nhập thông tin sách");
            System.out.println("2. Hiển thị thông tin sách");
            System.out.println("3. Cập nhật thông tin sách theo mã sách");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Sắp xếp theo giá bán tăng dần");
            System.out.println("6. Thống kê sách theo khoảng giá(a-b nhập từ bàn phím)");
            System.out.println("7. Tìm sách theo tên tác giả");
            System.out.println("8. Thoát");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        inputListBook(scanner);
                        break;
                    case 2:
                        displayListBook();
                        break;
                    case 3:
                        updateBookById(scanner);
                        break;
                    case 4:
                        deleteBookById(scanner);
                        break;
                    case 5:
                        sortListBookByExportPriceIncrease();
                        System.out.println("Đã xắp sếp danh sách theo giá bán tăng dần");
                        break;
                    case 6:
                        statisticListBookByExportPriceRange(scanner);
                        break;
                    case 7:
                        searchBookByAuthor(scanner);
                        break;
                    case 8:
                        writeDataToFile(listBook);
                        isExit = false;
                        break;
                    default:
                        System.out.println("Hãy chọn từ 1-8, vui lòng nhập lại");
                        break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Lựa chọn phải là số nguyên, vui lòng nhập lại");
            }
        } while (isExit);
    }
    public static void inputListBook(Scanner scanner){
        System.out.println("Nhập số lượng sách muốn thêm:");
        try {
            int numberOfBook = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numberOfBook; i++) {
                Book book = new Book();
                book.inputData(scanner);
                boolean add = listBook.add(book);
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
    public static void displayListBook(){
        for (Book book: listBook) {
            book.displayData();
        }
    }
    public static void updateBookById(Scanner scanner){
        System.out.println("Nhập id sách cần cập nhật thông tin:");
        try{
            int idBookUpdate = Integer.parseInt(scanner.nextLine());
            int indexUpdate = getIndexByBookId(idBookUpdate);
            if(indexUpdate >=0){
                listBook.get(indexUpdate).inputBookName(scanner);
                listBook.get(indexUpdate).inputImportPrice(scanner);
                listBook.get(indexUpdate).inputExportPrice(scanner);
                listBook.get(indexUpdate).inputAuthor(scanner);
                listBook.get(indexUpdate).inputDescription(scanner);
            }else {
                System.out.printf("Không tìm thấy sách có id là %d",idBookUpdate);
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
    public static int getIndexByBookId(int id){
        for (int i = 0; i < listBook.size(); i++) {
            if(listBook.get(i).getBookId() == id){
                return i;
            }
        }
        return -1;
    }
    public static void deleteBookById(Scanner scanner){
        System.out.println("Nhập Id sách cần xóa");
        try{
            int idBookDelete = Integer.parseInt(scanner.nextLine());
            int indexDelete = getIndexByBookId(idBookDelete);
            if(indexDelete >=0){
                listBook.remove(listBook.get(indexDelete));
                System.out.println("Xóa thành công sách");
            }else {
                System.out.printf("Không tìm thấy sách có id là %d để xóa",idBookDelete);
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
    public static void sortListBookByExportPriceIncrease(){
        Collections.sort(listBook, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if(o1.getExportPrice() > o2.getExportPrice()){
                    return 1;
                }else if(o1.getExportPrice() == o2.getExportPrice()){
                    return 0;
                }else {
                    return -1;
                }
            }
        });
    }
    public static void statisticListBookByExportPriceRange(Scanner scanner){
        float lowPrice;
        float highPrice;
        int cntBooks = 0;
        try {
            System.out.println("Nhập vào giá thấp trong khoảng giá:");
            lowPrice = Float.parseFloat(scanner.nextLine());
            System.out.println("Nhập vào giá cao trong khoảng giá:");
            do{
                highPrice = Float.parseFloat(scanner.nextLine());
                if(lowPrice > highPrice){
                    System.out.printf("Khoảng giá cao hơn phải lớp hơn %f, vui lòng nhập lại",lowPrice);
                }else {
                    break;
                }
            }while (true);
            for (Book book : listBook) {
                if(book.getExportPrice()>=lowPrice && book.getExportPrice()<=highPrice){
                    book.displayData();
                    cntBooks++;
                }
            }
            System.out.printf("Có %d sách có giá trong khoảng %f - %f",cntBooks,lowPrice,highPrice);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
    public static void searchBookByAuthor(Scanner scanner){
        int cntBooks = 0;
        System.out.println("Nhập tên tác sách cần tìm:");
        String author = scanner.nextLine();
        for (Book book: listBook) {
            if(book.getAuthor().toLowerCase().contains(author.toLowerCase())){
                book.displayData();
                cntBooks++;
            }
        }
        System.out.printf("Có %d sách của tác giả %s",cntBooks,author);
    }
    //Xây dựng phương thức ghi dữ liệu danh sách sinh viên ra file demo.txt
    public static void writeDataToFile(List<Book> listStudent) {
        //1. Khởi tạo đối tượng file
        File file = new File("books.txt");
        //2. Khởi tạo đối tượng FileOutputStream từ file
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //3. Khởi tạo đối tượng ObjectOutputStream để ghi dữ liệu ra file kiểu object
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //4. Sử dụng phương thức writeObject() để ghi dữ liệu ra file
            oos.writeObject(listStudent);
            //5. Đẩy dữ liệu từ stream xuống file
            oos.flush();
            //6. Đóng stream
            oos.close();
            fos.close();
        } catch (FileNotFoundException | NotSerializableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Book> readDataFromFile(){
        List<Book> listBooksRead = null;
        File file = new File("books.txt");
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listBooksRead = (List<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listBooksRead;
    }
}
