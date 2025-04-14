import ecs100.*;
/**
 * Screen class runs the graphical user interface and manages the buttons
 * @Sara
 */
public class Screen {
    // instance variables
    Manager manager; 

    /**
     * Constructor for objects of class Screen
     */
    public Screen() {
        // initialise instance variables
        manager = new Manager();
        
        UI.initialise();
        UI.addButton("Print All", manager::printAll);
        UI.addButton("Add", manager::getBookInfo); // get info of and add new book
        UI.addButton("Find", manager::findBook);
        UI.addButton("Quit", UI::quit);
    }
}
