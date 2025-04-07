import ecs100.*;
/**
 * Book class stores and returns the information of a book
 *
 * @Sara 
 * @date 2023-10-05
 */
public class Book {
    // instance variables 
    private double id;
    private String title;
    private String author;
    private int likes;
    //private String image;
    //private boolean clicked = false;

    /**
     * Constructor for objects of class Book
     */
    public Book(double key, String bookTitle, String bookAuthor, int numLikes) {
        // initialise instance variables
        id = key;
        title = bookTitle;
        author = bookAuthor;
        likes = numLikes;
    }
    
    /**
     * Returns the id of the book
     * @return id 
     */
    public double getId() {
        return id;
    }
    
    /**
     * Returns the title of the book
     * @return title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Returns the author of the book
     * @return author
     */
    public String getAuthor() {
        return author;
    }
    

    /**
     * Returns the number of likes of the book
     * @return likes
     */
    public int getLikes() {
        return likes;
    }

    /**public boolean bookClicked() {
        if () {
            clicked = true;
        }
        
        else {
            clicked = false;
        }
        
        return clicked;
    }*/
}