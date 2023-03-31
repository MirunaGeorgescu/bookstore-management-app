package ro.pao;
import ro.pao.application.Menu;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu menu = Menu.getInstance();
        menu.intro();

        int option = scanner.nextInt();
        Boolean exit = false;
        while(!exit){
            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Thank you for using our library!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}