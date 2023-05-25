package ro.pao.application;


import ro.pao.service.LibrarianService;
import ro.pao.service.MemberService;
import ro.pao.service.impl.LibrarianServiceImpl;
import ro.pao.service.impl.MemberServiceImpl;


import java.util.Scanner;

public class Menu {
    private static Menu INSTANCE;
    public static Menu getInstance(){
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }


    private final MemberService memberService = new MemberServiceImpl();
    private final LibrarianService librarianService = new LibrarianServiceImpl();


    LibrarianMenu librarianMenu = LibrarianMenu.getInstance();
    MemberMenu memberMenu = MemberMenu.getInstance();



    // MEMBER LOGIN SYSYEM
    // the memberLogin method: checks if the username and password are correct
    public String memberLogin(){
        String loginText = "------------------------------------- Welcome back! -------------------------------------\n" +
                "Please enter your username and password:\n" +
                "Username: ";
        System.out.println(loginText);

        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        loginText = "Password: ";
        System.out.println(loginText);
        String password = scanner.nextLine();

        if (memberService.isMember(username, password)){
            System.out.println("Login successful!\n");
            return username;
        } else {
            System.out.println("Login failed!\n");
            return null;
        }
    }

    // the introLoginFailed method: displays the menu for unsuccessful login
    public void introMemberLoginFailed(){
        String loginFailed = "----------------------------- LOGIN FAILED -----------------------------\n" +
                "The username or password you entered is incorrect. Are you sure you are a member?\n" +
                "Please select an option:\n" +
                "1. Try again\n" +
                "2. Create account\n" +
                "3. Go back to main menu";

        System.out.println(loginFailed);
    }

    // the memberLoginFailed method: displays the memberLoginFailed menu and handles the user's input
    public void memberLoginFailed(){
        Scanner scanner = new Scanner(System.in);
        Boolean exit = false;

        while(!exit){
            introMemberLoginFailed();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Try again
                    String username = memberLogin();
                    if(username != null){
                        // if login is successful, displays the member menu
                        memberMenu.memberMenu(username);
                    } else {
                        // if login is unsuccessful, displays the memberLoginFailed menu
                        memberLoginFailed();
                    }
                    break;
                case 2:
                    // Create account
                    newMember();
                    break;
                case 3:
                    // Go back to main menu
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }



    // LIBRARIAN LOGIN SYSTEM
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

    // the introLoginFailed method: displays the menu for unsuccessful login
    public void intoLibrarianLoginFailed(){
        String loginFailed = "----------------------------- LOGIN FAILED -----------------------------\n" +
                "The username or password you entered is incorrect. Are you sure you are a librarian?\n" +
                "Please select an option:\n" +
                "1. Try again\n" +
                "2. Create account\n" +
                "3. Go back to main menu";

        System.out.println(loginFailed);
    }

    // the librarianLoginFailed method: displays the librarianLoginFailed menu and handles the user's input
    public void librarianLoginFailed(){
        Scanner scanner = new Scanner(System.in);
        Boolean exit = false;

        while(!exit){
            intoLibrarianLoginFailed();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Try again
                    if(librarianLogin()){
                        // if login is successful, displays the librarian menu
                        librarianMenu.librarianMenu();
                    } else {
                        // if login is unsuccessful, displays the librarianLoginFailed menu
                        librarianLoginFailed();
                    }
                    break;
                case 2:
                    // Create account
                    newLibrarian();
                    break;
                case 3:
                    // Go back to main menu
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }



    // NEW MEMBER ACCOUNT SYSTEM
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



    // NEW LIBRARIAN ACCOUNT SYSTEM
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



    //MAIN MENU
    // the intro method: displays the welcome text and the main menu
    public void intro(){
        String intro = "-------------------------------- Welcome to the library! --------------------------------\n" +
                "Please choose an option:\n" +
                "1. Log in as a member\n" +
                "2. Log in as a librarian\n" +
                "3. Make a new member account\n" +
                "4. Make a new librarian account\n" +
                "5. Exit";
        System.out.println(intro);
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
                    String username = memberLogin();
                    if(username != null) {
                        // if login is successful, displays the member menu
                        memberMenu.memberMenu(username);
                    } else {
                        // if login is unsuccessful, displays the memberLoginFailed menu
                        memberLoginFailed();
                    }
                    break;
                case 2:
                    // Log in as a librarian
                    if(librarianLogin()) {
                        // if login is successful, display the librarian menu
                        librarianMenu.librarianMenu();
                    } else {
                        // if login is unsuccessful, display the librarianLoginFailed menu
                        librarianLoginFailed();
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
