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
                "1. Login as a member\n" +
                "2. Login as a librarian\n" +
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
}
