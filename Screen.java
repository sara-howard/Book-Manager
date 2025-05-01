import ecs100.*;
/**
 * Screen class runs the graphical user interface and manages the buttons.
 * @Sara
 */
public class Screen {
    // instance variables
    private Manager manager;

    /**
     * Constructor for objects of class Screen.
     */
    public Screen() {
        // initialise instance variables
        manager = new Manager();

        UI.initialise();
        UI.setMouseListener(manager::manageCovers); // set the mouse listener

        // print details of all books
        UI.addButton("Print All", manager::printAll);

        // get info of and and add new book
        UI.addButton("Add", manager::getBookInfo);

        // find and remove book
        UI.addButton("Remove", manager::removeBook);

        // find and print details of book
        UI.addButton("Find", manager::findBook);

        // end program
        UI.addButton("Quit", UI::quit);
    }

    /**
     * Main method to run the program.
     */
    public static void main(String[] args) {
        // Create instance of Screen class to therefore run the program
        new Screen();
    }
}
