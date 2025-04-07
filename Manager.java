import ecs100.*;
import java.util.HashMap;
/**
 * Manager class runs the program and manages the library
 *
 * @Sara
 * @date 2023-10-05
 */
public class Manager {
    // instance variables 
    private HashMap<Double, Book> library; // declaring the hashmap
    private Book currentBook;
    private String findTitle;
    
    /**
     * Constructor for objects of class Manager
     */
    public Manager() {
        // initialise instance variables
        // setup starting library
        library = new HashMap<Double, Book>();     // initialise hashmap
        
        // make books
        Book book1 = new Book(379853637, "The Wicked King", "Holly Black", 12);
        Book book2 = new Book(216547438, "Harry Potter", "JK. Rowling", 36);
        Book book3 = new Book(468390453, "1984", "George Orwell", 5);
        
        // add books to library
        library.put(book1.getId(), book1);
        library.put(book2.getId(), book2);
        library.put(book3.getId(), book3);

        // print menu and prompt for choice
        menu(); 
    }

    /**
     * Prints the menu
     * Forces a choice 
     * Calls appropriate method based on user input
     */
    public void menu() {
        // Print menu and force choice
        String choice;
        while (!choice.equalsIgnoreCase("Q")) {
            UI.println("(A)dd a book");
            UI.println("(F)ind a book");
            UI.println("(P)rint all");
            UI.println("(Q)uit");
            
            choice = UI.askString("Enter a choice: ");
            
            // If choice to add a book
            if (choice.equalsIgnoreCase("A")) {
                addBook();
            }
            
            // If choice to find a book
            else if (choice.equalsIgnoreCase("F")){
                // If book found
                if (findBook()) {
                    UI.println("Found!");
                    UI.println(currentBook.getTitle() + " by " 
                    + currentBook.getAuthor() + " has "
                    + currentBook.getLikes() + " likes");
                }
                // If book not found
                else {
                    UI.println(findTitle + " not found");
                }
            }

            // If choice to print all books
            else if (choice.equalsIgnoreCase("P")){
                printAll();
            }
            
            // If choice to quit
            else if (choice.equalsIgnoreCase("Q")){
                UI.println("Goodbye!");
                UI.quit();
            }
            
            // If input does not correspond to any of the choices
            else {
                // Prompt user to try again
                UI.println("Not a valid choice. Please try again!");
            }
        }
    }
    
    /**
     * Prompts user for book details
     * Adds a new book object to the library
     */
    public void addBook() {
        double id = UI.askDouble("ISBN: ");
        String title = UI.askString("Title: ");
        String author = UI.askString("Author: ");
        int likes = UI.askInt("Likes: ");
        library.put(id, new Book(id, title, author, likes));
    }
    
    /**
     * Prompts user for book title
     * Search for book in library
     * If found, sets book to currentBook 
     * @return if book found
     */
    public boolean findBook() {
        findTitle = UI.askString("Enter the books title: ");
        // Find book based on name
        for (double bookId : library.keySet()) {
            if ((library.get(bookId)).getTitle().equalsIgnoreCase(findTitle)) {
                currentBook = library.get(bookId);
                return true;
            }
        }
        return false;
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
        for (double bookId : library.keySet()) {
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
        Manager manager = new Manager(); 
    } 
}