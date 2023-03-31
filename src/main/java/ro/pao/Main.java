package ro.pao;
import ro.pao.application.Menu;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Menu menu = Menu.getInstance();
        menu.mainMenu();
    }
}