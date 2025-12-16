import java.io.*;
import java.util.*;

public class LibraryManagementSystem {
    private static final String FILE_NAME = "books.dat"; // file for storage
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadBooks(); // Load books from file
        int choice;

        do {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. View All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Enter a number: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> searchBook();
                case 4 -> viewBooks();
                case 5 -> {
                    saveBooks();
                    System.out.println("Exiting. Goodbye!");
                }
                default -> System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);
    }

    // Add a new book
    private static void addBook() {
        System.out.print("Enter Book ID: ");
        String id = sc.nextLine().trim();

        // Check for duplicate ID
        for (Book b : books) {
            if (b.getId().equalsIgnoreCase(id)) {
                System.out.println("Book ID already exists! Try again.");
                return;
            }
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine().trim();
        System.out.print("Enter Book Author: ");
        String author = sc.nextLine().trim();

        if (id.isEmpty() || title.isEmpty() || author.isEmpty()) {
            System.out.println("All fields are required! Try again.");
            return;
        }

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    // Remove a book by ID
    private static void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        String id = sc.nextLine().trim();

        boolean removed = books.removeIf(book -> book.getId().equalsIgnoreCase(id));

        if (removed) System.out.println("Book removed successfully!");
        else System.out.println("Book not found!");
    }

    // Search for a book by ID or title
    private static void searchBook() {
        System.out.print("Enter Book ID or Title to search: ");
        String key = sc.nextLine().trim();
        boolean found = false;

        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(key) || book.getTitle().equalsIgnoreCase(key)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) System.out.println("Book not found!");
    }

    // View all books
private static void viewBooks() {
    if (books.isEmpty()) {
        System.out.println("No books available.");
    } else {
        System.out.println("\n--- All Books ---");
        System.out.printf("| %-8s | %-35s | %-20s |%n", "Book ID", "Title", "Author");
        System.out.println("--------------------------------------------------------------------------");
        
        for (Book book : books) {
            String title = book.getTitle();
            String author = book.getAuthor();
            
            // Truncate if too long
            if (title.length() > 35) title = title.substring(0, 32) + "...";
            if (author.length() > 20) author = author.substring(0, 17) + "...";
            
            System.out.printf("| %-8s | %-35s | %-20s |%n", book.getId(), title, author);
        }
        System.out.println("--------------------------------------------------------------------------");
    }
}




    // Save books to file
    private static void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    // Load books from file
    private static void loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (ArrayList<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            books = new ArrayList<>(); // first time running
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading books: " + e.getMessage());
            books = new ArrayList<>();
        }
    }
}
