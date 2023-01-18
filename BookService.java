package service;

import model.Book;
import repository.BookRepository;

import java.util.Collection;
import java.util.Random;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        generateBooks();
    }

    private void generateBooks() {
        for (int i = 0; i < 50; ++i) {
            int leftLimit = 97;
            int rightLimit = 122;
            int targetStringLength = 10;
            Random random = new Random();
            StringBuilder bufferTitle = new StringBuilder(targetStringLength);
            StringBuilder bufferAuthor = new StringBuilder(targetStringLength);
            for (int j = 0; j < targetStringLength; j++) {
                int randomLimitedIntTitle = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                bufferTitle.append((char) randomLimitedIntTitle);
                int randomLimitedIntAuthor = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                bufferAuthor.append((char) randomLimitedIntAuthor);
            }
            this.addBook(new Book(bufferTitle.toString(), bufferAuthor.toString(), random.nextInt(200)));
        }
    }

    private void addBook(Book book) {
        this.bookRepository.add(book);
    }

    public Collection<Book> getAll() {
        return bookRepository.getAll();
    }
}
