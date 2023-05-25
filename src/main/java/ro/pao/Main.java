package ro.pao;
import ro.pao.application.Database;
import ro.pao.application.Menu;


public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        database.populateDatabase();

        Menu menu = Menu.getInstance();
        menu.mainMenu();
    }
}