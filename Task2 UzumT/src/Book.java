import java.util.ArrayList;

public class Book {
    String isbn;
    String name;
    String author;
    int year;
    boolean status; // true = available, false = reserved
    static ArrayList<Book> books = new ArrayList<>();

    public void getBookInfo() {
        System.out.println("Book: " + name + " (" + year + ") by " + author);
        System.out.println("Status: " + (status ? "Available" : "Reserved"));
    }

    public static void getBooks() {
        for (Book b : books) {
            b.getBookInfo();
            System.out.println();
        }
    }

    public static void addNewBook(Book b) {
        books.add(b);
    }

    public void reserveBook() {
        if (status) {
            status = false;
            System.out.println(name + " reserved successfully.");
        } else {
            System.out.println(name + " is already reserved.");
        }
    }
}

