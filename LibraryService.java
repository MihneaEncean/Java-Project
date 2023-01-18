package service;

import model.Book;
import model.Subscriber;
import model.SubscriberTypes;
import repository.BookRepository;
import repository.SubscriberRepository;

import java.util.Objects;

public class LibraryService {
    private final BookRepository bookRepository;
    private final SubscriberRepository subscriberRepository;

    public LibraryService(BookRepository bookRepository, SubscriberRepository subscriberRepository) {
        this.bookRepository = bookRepository;
        this.subscriberRepository = subscriberRepository;
    }

    public void borrowBook(String subscriberName, String bookTitle, String bookAuthor, Integer timeUnits) {
        Book book = bookRepository.getByTitleAndAuthor(bookTitle, bookAuthor);
        if (Objects.nonNull(book.getBorrowedBy())) {
            return;
        }
        Subscriber subscriber = subscriberRepository.getByName(subscriberName);
        subscriber.setMoney(subscriber.getMoney() - book.getPrice());
        book.setBorrowedBy(subscriber);
    }
}
