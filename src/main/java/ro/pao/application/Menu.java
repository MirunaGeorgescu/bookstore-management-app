package ro.pao.application;

import ro.pao.model.Book;
import ro.pao.service.LibrarianService;
import ro.pao.service.MemberService;
import ro.pao.service.impl.LibrarianServiceImpl;
import ro.pao.service.impl.MemberServiceImpl;
import ro.pao.service.impl.BookServiceImpl;
import ro.pao.service.BookService;

import java.util.Scanner;

public class Menu {
    private static Menu INSTANCE;
    private final MemberService memberService = new MemberServiceImpl();
    private final LibrarianService librarianService = new LibrarianServiceImpl();
    private final BookService bookService = new BookServiceImpl();

    public static Menu getInstance(){
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    // the intro method: displays the welcome text and the main menu
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

    public Boolean bookGenreValidation(String genre){
        if(genre.equalsIgnoreCase("FANTASY")
                || genre.equalsIgnoreCase("ROMANCE")
                || genre.equalsIgnoreCase("SCIENCE_FICTION")
                || genre.equalsIgnoreCase("LITERARY_FICTION")
                || genre.equalsIgnoreCase("HORROR")
                || genre.equalsIgnoreCase("MYSTERY")
                || genre.equalsIgnoreCase("THRILLER")){
            genre.toUpperCase();
            return true;
        } else {
            return false;
        }
    }

    // the newBook method: creates a new book
    public void newBook(){
        Scanner scanner = new Scanner(System.in);

        String newBookText = "----------------------------- NEW BOOK -----------------------------\n" +
                "Please enter the book's title: ";
        System.out.println(newBookText);
        String title = scanner.nextLine();

        newBookText = "Please enter the book's author: ";
        System.out.println(newBookText);
        String author = scanner.nextLine();


        newBookText = "Please enter the book's genre: ";
        System.out.println(newBookText);
        String genre = scanner.nextLine();
        while(!bookGenreValidation(genre)){
            System.out.println("Invalid genre! The options are:\n " +
                    "-> FANTASY\n -> ROMANCE\n -> SCIENCE_FICTION\n -> LITERARY_FICTION\n -> HORROR\n -> MYSTERY\n -> THRILLER\n" +
                    "Please enter a valid genre: ");
            genre = scanner.nextLine();
        }

        newBookText = "Please enter the book's ISBN: ";
        System.out.println(newBookText);
        String isbn = scanner.nextLine();

        newBookText = "Please enter the book's publisher: ";
        System.out.println(newBookText);
        String publisher = scanner.nextLine();

        newBookText = "Please enter the book's date (dd/mm/yyyy) of publication: ";
        System.out.println(newBookText);
        String date = scanner.nextLine();

        newBookText = "Please enter the book's language: ";
        System.out.println(newBookText);
        String language = scanner.nextLine();

        newBookText = "Please enter the book's number of pages: ";
        System.out.println(newBookText);
        Integer pages = scanner.nextInt();

        newBookText = "Please enter the book's price: ";
        System.out.println(newBookText);
        Double price = scanner.nextDouble();

        newBookText = "Please enter the book's number of copies: ";
        System.out.println(newBookText);
        Integer copies = scanner.nextInt();

        Book book = new Book(isbn, title, author, publisher, genre, date, language, pages, price, copies);
        bookService.addBook(book);
    }

    // the introBookNotFound method: displays the options when a book is not found
    public void introBookNotFound(){
        String bookNotFoundText = "----------------------------- BOOK NOT FOUND -----------------------------\n" +
                "Please choose an option:\n" +
                "1. Try again\n" +
                "2. Go back to the menu\n";
    }

    // the bookNotFound method: displays the intro and handles the librarians input
    public void bookNotFound(){
        introBookNotFound();
        Scanner scanner = new Scanner(System.in);

        String option = scanner.nextLine();
        Boolean exit = false;
        while(!exit)
        {
            switch(option){
                case "1":
                    // Try again
                    removeBook();
                    exit = true;
                    break;
                case "2":
                    // Go back to the menu
                    librarianMenu();
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option! Please try again: ");
                    option = scanner.nextLine();
                    break;
            }
        }
    }

    public void removeBook(){
        Scanner scanner = new Scanner(System.in);
        String removeBookText = "----------------------------- REMOVE BOOK -----------------------------\n" +
                "Please enter the book's ISBN: ";
        System.out.println(removeBookText);
        String isbn = scanner.nextLine();

        if(bookService.getBookByISBN(isbn) == null){
            System.out.println("Book not found!");
            bookNotFound();

        } else {
            bookService.deleteBookByISBN(isbn);
            System.out.println("Book removed successfully!");
        }
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
                    newBook();
                    break;
                case 2:
                    // Remove a book
                    removeBook();
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
                    System.out.println("Logging out...");
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
                    System.out.println("See you next time!\n Logging out...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
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
                    if(memberLogin()){
                        // if login is successful, displays the member menu
                        memberMenu();
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
                        librarianMenu();
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
                        // if login is unsuccessful, displays the memberLoginFailed menu
                        memberLoginFailed();
                    }
                    break;
                case 2:
                    // Log in as a librarian
                    if(librarianLogin()) {
                        // if login is successful, display the librarian menu
                        librarianMenu();
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
