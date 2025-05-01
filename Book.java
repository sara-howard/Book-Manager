import ecs100.*;
/**
 * Book class stores and returns the information of a book.
 * @Sara
 */
public class Book {
    // instance variables
    private final long id;
    private final String title;
    private final String author;
    private int likes;
    private String cover;
    private boolean clicked = false;

    // cover dimensions
    private int locX;
    private int locY;
    private double width;
    private double height;

    /**
     * Constructor for objects of class Book.
     */
    public Book(long key, String bookTitle, String bookAuthor, int numLikes,
    String bookCover) {
        // initialise instance variables
        id = key;
        title = bookTitle;
        author = bookAuthor;
        likes = numLikes;
        cover = bookCover;

        // cover dimensions
        locX = 100;
        locY = 100;
        width = 100;
        height = 180;
    }

    /**
     * Display the books cover.
     */
    public void displayCover() {
        // display cover image
        UI.drawImage(cover, locX, locY, width, height);
    }

    /**
     * Edit book likes.
     * @param likesChange - number to increase the books likes by
     */
    public void editLikes(long likesChange) {
        likes += likesChange;
    }

    /**
     * Check if book cover has been clicked.
     * No buffer space
     * @return clicked - returns true if mouse click on cover, otherwise false
     */
    public boolean onCover(double x, double y) {
        if ((x >= locX) && (x <= locX + width)
        &&
            (y >= locY) && (y <= locY + height)) {
            clicked = true;
        } else {
            clicked = false;
        }

        return clicked;
    }

    /**
     * Returns the id of the book.
     * @return id
     */
    public double getId() {
        return id;
    }

    /**
     * Returns the title of the book.
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the book.
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the number of likes of the book.
     * @return likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Returns the book cover.
     * @return cover
     */
    public String getCover() {
        return cover;
    }
}
