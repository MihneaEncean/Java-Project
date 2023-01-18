package view;

import model.Book;
import model.Subscriber;
import service.BookService;
import service.LibraryService;
import service.SubscriberService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

public class Console {
    private HashMap<String, Method> consoleMap;
    private final BookService bookService;
    private final SubscriberService subscriberService;
    private final LibraryService libraryService;

    public Console(BookService bookService, SubscriberService subscriberService, LibraryService libraryService) {
        this.subscriberService = subscriberService;
        this.libraryService = libraryService;
        try {
            this.consoleMap = new HashMap<>() {{
                put("1", Console.class.getMethod("printAllBooks"));
                put("2", Console.class.getMethod("printAllSubscribers"));
                put("3", Console.class.getMethod("borrowBook"));
            }};
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        this.bookService = bookService;
    }

    public void printAllBooks() {
        Collection<Book> books = bookService.getAll();

        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + " | Author: " + book.getAuthor() + " | Price: " +
                    book.getPrice() + " | Borrowed by: " +
                    (Objects.nonNull(book.getBorrowedBy()) ? book.getBorrowedBy().getName() : "None"));
        }
    }

    public void printAllSubscribers() {
        Collection<Subscriber> subscribers = subscriberService.getAll();

        for (Subscriber subscriber : subscribers) {
            System.out.println("Name: " + subscriber.getName() + " | Money: " + subscriber.getMoney() + " | Type: " +
                    subscriber.getType());
        }
    }

    public void borrowBook() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Subscriber name: ");
            String subscriberName = reader.readLine();

            System.out.println("Book title: ");
            String bookTitle = reader.readLine();

            System.out.println("Book author: ");
            String bookAuthor = reader.readLine();

            System.out.println("Time: ");
            Integer timeUnits = Integer.valueOf(reader.readLine());

            libraryService.borrowBook(subscriberName, bookTitle, bookAuthor, timeUnits);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printMenu() {
        System.out.println("0. Exit");
        System.out.println("1. See books");
        System.out.println("2. See subscribers");
        System.out.println("3. Borrow a book\n");
    }

    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            printMenu();

            System.out.println("Choice:");
            try {
                String choice = bufferedReader.readLine();
                if (choice.equals("0")) {
                    return;
                }
                this.consoleMap.get(choice).invoke(this);
            } catch (IOException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
