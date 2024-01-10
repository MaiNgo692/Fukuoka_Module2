package com.ra.service.impl;

import com.ra.entity.impl.Book;
import com.ra.service.IBookService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookService implements IBookService {
    private static List<Book> books = new ArrayList<>();

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findId(int id) {
        for (Book b: books) {
            if(b.getBookId()== id){
                return b;
            }
        }
        return null;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void remove(int id) {
        Book book = findId(id);
        if(book != null){
            books.remove(book);
        }else {
            System.out.println("Không tìm thấy sách có id= " + id);
        }
    }

    @Override
    public List<Book> sortByPrice() {
        List<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort((b1,b2) -> Float.compare(b1.getExportPrice(),b2.getExportPrice()));
        return sortedBooks;
    }

    @Override
    public List<Book> findPriceBetween(float from, float to) {
        return books.stream().filter(b -> b.getExportPrice() >= from && b.getExportPrice()<= to).collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book b: books) {
            if(b.getAuthor().contains(author)){
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public boolean findAny(Predicate<Book> predicate) {
        for (Book b: books) {
            if(predicate.test(b)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void load() {
        try{
            File file = new File("books.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            books = (List<Book>)ois.readObject();
            ois.close();
            fis.close();
        }catch (Exception e){
            books = new ArrayList<>();
        }
    }

    @Override
    public void save() {
        try{
            File file =  new File("books.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.flush();
            oos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
