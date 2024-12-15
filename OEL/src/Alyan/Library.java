package Alyan;
import java.util.*;

class Library {
    private Map<String, Book> bookMap; // Hash table for quick search
    private TreeSet<Book> bookTree;   // BST for sorted listing

    public Library() {
        bookMap = new HashMap<>();
        bookTree = new TreeSet<>(Comparator.comparing(b -> b.title));
    }

    public void addBook(Book book) {
        if (bookMap.containsKey(book.title)) {
            System.out.println("Book with this title already exists!");
            return;
        }
        bookMap.put(book.title, book);
        bookTree.add(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(String title) {
        Book book = bookMap.remove(title);
        if (book != null) {
            bookTree.remove(book);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public Book searchBook(String title) {
        return bookMap.getOrDefault(title, null);
    }

    public void listBooks() {
        System.out.println("Books in library (sorted by title):");
        for (Book book : bookTree) {
            System.out.println(book);
        }
    }
}
