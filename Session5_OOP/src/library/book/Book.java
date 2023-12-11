package library.book;

import library.author.Author;

public class Book {
    private String id;
    private String title;
    private Author author;
    private double price;

    public Book() {
    }

    public Book(String id, String title, Author author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void output() {
        System.out.println("Sách "+ title + " Tác giả: "+ author.getName() +" Price: "+ price);
    }
}
