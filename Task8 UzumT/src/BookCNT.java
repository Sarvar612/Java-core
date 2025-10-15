import java.util.*;

class Book {
    String name;
    String author;
    String isbn;

    public Book(String name, String author, String isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return name + " (" + author + "), ISBN: " + isbn;
    }
}

public class BookCNT{
    public static void main(String[] args) {
        HashMap<String, Book> books = new HashMap<>();

        books.put("12345", new Book("Java Learn", "Alex Atomson", "12345"));
        books.put("67890", new Book("Python Learn", "Jack Tom", "67890"));
        books.put("11223", new Book("C# Learn", "Niki Jackson", "11223"));

        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
}
