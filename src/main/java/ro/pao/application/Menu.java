package ro.pao.application;

import ro.pao.service.LibrarianService;
import ro.pao.service.MemberService;
import ro.pao.service.impl.LibrarianServiceImpl;
import ro.pao.service.impl.MemberServiceImpl;

import java.util.Scanner;

public class Menu {
    private static Menu INSTANCE;
    private final MemberService memberService = new MemberServiceImpl();
    private final LibrarianService librarianService = new LibrarianServiceImpl();

    public static Menu getInstance(){
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    // the intro method: displays the menu
    public void intro(){
        String intro = "--------------------------- Welcome to the library! ---------------------------\n" +
                "Please choose an option:\n" +
                "1. Log in as a member\n" +
                "2. Log in as a librarian\n" +
                "3. Make a new member account\n" +
                "4. Make a new librarian account\n" +
                "5. Exit";
        System.out.println(intro);
    }

    // the memberLogin method: checks if the username and password are correct
    public Boolean memberLogin(){
        String loginText = "----------------------------- Welcome back! -----------------------------\n" +
                "Please enter your username and password:\n" +
                "Username: ";
        System.out.println(loginText);

        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        loginText = "Password: ";
        System.out.println(loginText);
        String password = scanner.nextLine();

        if (memberService.isMember(username, password)){
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed!");
            return false;
        }
    }

    // the librarianLogin method: checks if the username and password are correct
    public Boolean librarianLogin(){
        String loginText = "----------------------------- Welcome back! -----------------------------\n" +
                "Please enter your username and password:\n" +
                "Username: ";
        System.out.println(loginText);

        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        loginText = "Password: ";
        System.out.println(loginText);
        String password = scanner.nextLine();

        if (librarianService.isLibrarian(username, password)){
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed!");
            return false;
        }
    }

    // the newMember method: creates a new member account
    public void newMember(){
        String newMemberText = "----------------------------- Welcome! Create your account -----------------------------\n" +
                "Please enter your username and password:\n" +
                "Username: ";
        System.out.println(newMemberText);

        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        newMemberText = "Password: ";
        System.out.println(newMemberText);
        String password = scanner.nextLine();

        newMemberText = "Please enter your name: ";
        System.out.println(newMemberText);
        String name = scanner.nextLine();

        newMemberText = "Please enter your address: ";
        System.out.println(newMemberText);
        String address = scanner.nextLine();

        newMemberText = "Please enter your email: ";
        System.out.println(newMemberText);
        String email = scanner.nextLine();

        newMemberText = "Please enter your phone number: ";
        System.out.println(newMemberText);
        String phoneNumber = scanner.nextLine();

        memberService.createMember(username, password, name, address, email, phoneNumber);

        System.out.println("Account created successfully!");
    }

    // the newLibrarian method: creates a new librarian account
    public void newLibrarian(){
        String newMemberText = "----------------------------- Welcome! Create your account -----------------------------\n" +
                "Please enter your username and password:\n" +
                "Username: ";
        System.out.println(newMemberText);

        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        newMemberText = "Password: ";
        System.out.println(newMemberText);
        String password = scanner.nextLine();

        newMemberText = "Please enter your name: ";
        System.out.println(newMemberText);
        String name = scanner.nextLine();

        newMemberText = "Please enter your address: ";
        System.out.println(newMemberText);
        String address = scanner.nextLine();

        newMemberText = "Please enter your email: ";
        System.out.println(newMemberText);
        String email = scanner.nextLine();

        newMemberText = "Please enter your phone number: ";
        System.out.println(newMemberText);
        String phoneNumber = scanner.nextLine();

        librarianService.createLibrarian(username, password, name, address, email, phoneNumber);

        System.out.println("Account created successfully!");
    }

    // the introLibrarianMenu: displays the menu for the librarians
    public void intoLibrarianMenu(){
        String intro = "----------------------------- LIBRARIAN MENU -----------------------------\n" +
                "Please choose an option:\n" +
                "1. Add a book\n" +
                "2. Remove a book\n" +
                "3. View all books\n" +
                "4. Search for a book\n" +
                "5. View all members\n" +
                "6. Search for a member\n" +
                "7. Log out";
        System.out.println(intro);
    }

    // the librarianMenu method: displays the welcome text, the menu for librarians and handles the user's input
    public void librarianMenu(){
        Scanner scanner = new Scanner(System.in);
        Boolean exit = false;

        while(!exit)
        {
            intoLibrarianMenu();
            int option = scanner.nextInt();

            switch(option){
                case 1:
                    // Add a book
                    break;
                case 2:
                    // Remove a book
                    break;
                case 3:
                    // View all books
                    break;
                case 4:
                    // Search for a book
                    break;
                case 5:
                    // View all members
                    break;
                case 6:
                    // Search for a member
                    break;
                case 7:
                    // Log out
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

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
                    System.out.println("See you next time!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    // the mainMenu method: displays the welcome text, the main menu and handles the user's input
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        Boolean exit = false;

        while(!exit){
            intro();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Log in as a member
                    if(memberLogin()){
                        // if login is successful, displays the member menu
                        memberMenu();
                    } else {
                        // if login is unsuccessful, displays the loginFailed menu
                    }
                    break;
                case 2:
                    // Log in as a librarian
                    if(librarianLogin()) {
                        // if login is successful, display the librarian menu
                        librarianMenu();
                    } else {
                        // if login is unsuccessful, display the loginFailed menu
                    }
                    break;
                case 3:
                    // Make a new member account
                    newMember();
                    break;
                case 4:
                    // Make a new librarian account
                    newLibrarian();
                    break;
                case 5:
                    // Exit
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
