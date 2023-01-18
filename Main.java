import repository.BookRepository;
import repository.SubscriberRepository;
import service.BookService;
import service.LibraryService;
import service.SubscriberService;
import view.Console;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        SubscriberRepository subscriberRepository = new SubscriberRepository();
        BookService bookService = new BookService(bookRepository);
        SubscriberService subscriberService = new SubscriberService(subscriberRepository);
        LibraryService libraryService = new LibraryService(bookRepository, subscriberRepository);
        Console console = new Console(bookService, subscriberService, libraryService);
        console.run();
    }
}
