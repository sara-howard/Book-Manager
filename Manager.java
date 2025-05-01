import ecs100.*;
import java.util.HashMap;
/**
 * Manager class runs the program and manages the library.
 * @Sara
 */
public class Manager {
    // instance variables
    private HashMap<Long, Book> library; // declaring the hashmap
    private Book currentBook;
    private String findTitle;

    // variables to use when adding a new book
    private long newId;
    private String newTitle;
    private String newAuthor;
    private int newLikes;
    private String newCover;
    private String newString;

    /**
     * Constructor for objects of class Manager.
     */
    public Manager() {
        // initialise instance variables
        // setup starting library
        library = new HashMap<Long, Book>();

        // add books to library
        addBook(379853637, "The Wicked King", "Holly Black", 12,
        "wicked_king.png");
        addBook(216547438, "Harry Potter", "JK. Rowling", 36,
        "harry_potter.png");
        addBook(468390453, "1984", "George Orwell", 5, "1984.png");

    }

    /**
     * Manage the book covers.
     * 
     */
    public void manageCovers(final String action,
    final double x, final double y) {
        if (action.equals("released")) {
            if (currentBook.onCover(x, y)) {
                currentBook.editLikes(1);
                UI.println("Likes increased by 1!");
                printDetails();
            }
        }
    }

    /**
     * Prompts user for book details.
     */
    public void getBookInfo() {
        newId = newId();

        newTitle = newString("Title: ", "A book has to have a title!");
        newTitle = newString("Author: ", "A book has to have an author!");
        newLikes = UI.askInt("Likes: ");

        // add an image for book cover display in GUI
        newCover = UIFileChooser.open("Choose Book Cover: ");

        addBook(newId, newTitle, newAuthor, newLikes, newCover);
        UI.println(newTitle + " has been added to your library!");
    }

    /**
     * Force the user to enter a new string until != null.
     * @return newString 
     */
    public String newString(String prompt, String nullMessage) {
        do {
            newString = UI.askString(prompt);

            if (newString.isEmpty()) {
                UI.println(nullMessage);
            }
        } while (newString.isEmpty());
        return newString;
    }

    /**
     * Prompts user for a new ISBN.
     * @return newId
     */
    public long newId() {
        do {
            try {
                newId = Long.decode(UI.askString("ISBN: "));
            } catch (Exception NumberFormatException) {
                // If non number given (null or string)
                newId = 0;
            }

            // If ISBN is already in library
            if (library.containsKey(newId)) {
                newId = 0;
            }

            // Give error message if input invalid
            if (newId <= 0) {
                UI.println("Invalid ISBN. Please try again");
            }

        } while (newId <= 0); // Force input until positive number given

        return newId;
    }

    /**
     * Adds a new book object to the library.
     */
    public void addBook(long id, String title, String author,
    int likes, String cover) {
        library.put(id, new Book(id, title, author, likes, cover));
    }

    /**
     * Prompts user for book title.
     * Search for book in library
     * If found, sets book to currentBook.
     * @return if book found (true/false)
     */
    public boolean checkBook() {
        findTitle = UI.askString("Enter the books title: ");
        // Find book based on name
        for (long bookId : library.keySet()) {
            if ((library.get(bookId)).getTitle().equalsIgnoreCase(findTitle)) {
                currentBook = library.get(bookId);
                return true;
            }
        }
        return false;
    }

    /**
     * If book found, prints the book details.
     * If not found, prints "Book not found"
     */
    public void findBook() {
        if (checkBook()) {
            UI.println("Book found: ");
            printDetails();
            // Display book cover
            currentBook.displayCover();
        } else {
            UI.println("Book not found");
        }
    }

    /**
     * Print book details with formatting.
     */
    public void printDetails() {
        UI.println("---------------------");
            UI.println(currentBook.getTitle() + " by "
                        + currentBook.getAuthor());
            UI.println("- " + currentBook.getLikes() + " likes");
            UI.println("---------------------");
    }

    /**
     * If book found, removes and prints "___ removed".
     * If not found, prints "___ isn't in your library"
     */
    public void removeBook() {
        if (checkBook()) {
            library.remove(currentBook.getId());
            UI.println(currentBook + " removed");
        } else {
            UI.println(currentBook + " isn't in your library");
        }
    }

    /**
     * Prints all books in the library.
     * Prints the title, author and number of likes of each book
     */
    public void printAll() {
        // Traverse library
        for (long bookId : library.keySet()) {
            currentBook = library.get(bookId);
            printDetails();
        }
    }

    /**
     * Returns the current book.
     * @return currentBook
     */
    public Book getCurrentBook() {
        return currentBook;
    }
}
