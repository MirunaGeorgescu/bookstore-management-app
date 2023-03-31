package ro.pao;
import ro.pao.application.Menu;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu menu = Menu.getInstance();


        Boolean exit = false;
        while(!exit){
            menu.intro();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    if(menu.memberLogin()){
                        // if login is successful, display the member menu
                        //TODO: member menu
                    } else {
                        // if login is unsuccessful, display the loginFailed menu
                    }
                    break;
                case 2:
                    if(menu.librarianLogin()) {
                        // if login is successful, display the librarian menu
                        //TODO: librarian menu
                    } else {
                        // if login is unsuccessful, display the loginFailed menu
                    }
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