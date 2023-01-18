package repository;

import model.Book;

import java.util.ArrayList;
import java.util.Collection;

public class BookRepository {
    Collection<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();
    }

    public Collection<Book> getAll() {
        return books;
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public Book getByTitleAndAuthor(String bookTitle, String bookAuthor) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle) && book.getAuthor().equals(bookAuthor)) {
                return book;
            }
        }
        return null;
    }
}
