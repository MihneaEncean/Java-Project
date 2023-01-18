package model;

public class Book {
    private final String title;
    private final String author;
    private final Integer price;
    private Subscriber borrowedBy;

    public Subscriber getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Subscriber borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public Book(String title, String author, Integer price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPrice() {
        return price;
    }
}
