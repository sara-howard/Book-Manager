import ecs100.*;
import java.util.HashMap;
/**
 * Manager class runs the program and manages the library
 *
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
    private String newString;
    
    /**
     * Constructor for objects of class Manager
     */
    public Manager() {
        // initialise instance variables
        // setup starting library
        library = new HashMap<Long, Book>();     // initialise hashmap
        
        // add books to library
        addBook(379853637, "The Wicked King", "Holly Black", 12);
        addBook(216547438, "Harry Potter", "JK. Rowling", 36);
        addBook(468390453, "1984", "George Orwell", 5);

    }
    
    /**
     * Prompts user for book details
     */
    public void getBookInfo() {
        newId = newId();
    
        newTitle = newString("Title: ", "A book has to have a title!");
        newTitle = newString("Author: ", "A book has to have an author!");
        newLikes = UI.askInt("Likes: ");
        
        addBook(newId, newTitle, newAuthor, newLikes);
        UI.println(newTitle + " has been added to your library!");
    }

    /*
     * Force the user to enter a new string until != null
     */
    public String newString(String prompt, String errorMessage) {
        do {
            newString = UI.askString(prompt);

            if (newString.isEmpty() == true) {
                UI.println(errorMessage);
            }
        } while (newString.isEmpty() == true);;
        return newString;
    }

    /**
     * Prompts user for a new ISBN
     * @return newId
     */
    public long newId() {
        do { 
            try {
                newId = Long.decode(UI.askString("ISBN: "));
            }
            
            // If non number given (null or string)
            catch (Exception NumberFormatException) {
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
     * Adds a new book object to the library
     */
    public void addBook(long id, String title, String author, int likes) {
        library.put(id, new Book(id, title, author, likes));
    }

    /**
     * Prompts user for book title
     * Search for book in library
     * If found, sets book to currentBook 
     * @return if book found
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
     * If book is found, prints the book details
     * If not found, prints "Book not found"
     */
    public void findBook() {
        if (checkBook()) {
            UI.println("Book found: " + currentBook.getTitle() + " "
                        + currentBook.getAuthor() + " "
                        + currentBook.getLikes());
        } 
        
        else {
            UI.println("Book not found");
        }
    }

    /**
     * Returns the current book
     * @return currentBook
     */
    public Book getCurrentBook() {
        return currentBook;
    }
    
    /**
     * Prints all books in the library
     * Prints the title, author and number of likes of each book
     */
    public void printAll() {
        // Traverse library
        for (long bookId : library.keySet()) {
            UI.println(bookId + " Details: ");
            UI.println(library.get(bookId).getTitle() + " "
                        + library.get(bookId).getAuthor() + " "
                        + library.get(bookId).getLikes());
        }
    }
    
    /**
     * Main method to run the program
     */
    public static void main(String[] args) {
        // Create a new instance of the Manager class to therefore run the program
        new Screen();
    } 
}