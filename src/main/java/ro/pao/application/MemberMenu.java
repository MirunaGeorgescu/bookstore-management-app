package ro.pao.application;

import java.util.Scanner;

public class MemberMenu {
    private static MemberMenu INSTANCE;
    public static MemberMenu getInstance() {
        return (INSTANCE == null ? new MemberMenu() : INSTANCE);
    }



    //MEMBER MENU
    // the introMemberMenu: displays the menu for the members
    public void introMemberMenu(){
        String intro = "----------------------------- MEMBER MENU -----------------------------\n" +
                "Please choose an option:\n" +
                "1. Borrow a book\n" +
                "2. Return a book\n" +
                "3. View borrowed books\n" +
                "4. Search for a book\n" +
                "5. View all books\n" +
                "6. Log out";
        System.out.println(intro);
    }

    // the memberMenu method: displays the welcome text, the menu for members and handles the user's input
    public void memberMenu(){
        Scanner scanner = new Scanner(System.in);
        Boolean exit = false;

        while(!exit)
        {
            introMemberMenu();
            int option = scanner.nextInt();

            switch(option){
                case 1:
                    // Borrow a book
                    break;
                case 2:
                    // Return a book
                    break;
                case 3:
                    // View borrowed books
                    break;
                case 4:
                    // Search for a book
                    break;
                case 5:
                    // View all books
                    break;
                case 6:
                    // 6. Log out
                    System.out.println("See you next time!\nLogging out...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}
