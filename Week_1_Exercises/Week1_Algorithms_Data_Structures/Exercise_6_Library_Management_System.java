

import java.util.Arrays;
import java.util.Comparator;

// Step 2: Setup - Create Book class
class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class Exercise_6_Library_Management_System {

    // Step 3: Implementation - Linear Search
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Step 3: Implementation - Binary Search
    public static Book binarySearch(Book[] books, String title) {
        Arrays.sort(books, Comparator.comparing(Book::getTitle));
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("101", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("102", "1984", "George Orwell"),
            new Book("103", "To Kill a Mockingbird", "Harper Lee"),
            new Book("104", "Moby Dick", "Herman Melville"),
            new Book("105", "War and Peace", "Leo Tolstoy")
        };

        // Linear Search
        System.out.println("Linear Search:");
        Book result1 = linearSearch(books, "1984");
        System.out.println(result1 != null ? result1 : "Book not found");

        // Binary Search
        System.out.println("\nBinary Search:");
        Book result2 = binarySearch(books, "1984");
        System.out.println(result2 != null ? result2 : "Book not found");
    }
}
