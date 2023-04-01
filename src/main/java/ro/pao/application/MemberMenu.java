package ro.pao.application;

import ro.pao.service.BookService;
import ro.pao.service.impl.BookServiceImpl;

import java.util.Scanner;

public class MemberMenu {
    private static MemberMenu INSTANCE;
    public static MemberMenu getInstance() {
        return (INSTANCE == null ? new MemberMenu() : INSTANCE);
    }



    private final BookService bookService = new BookServiceImpl();



    // SEARCHING FOR BOOKS
    // the introSearchBooks method: displays the menu for searching books
    public void introSearchBooks(){
        Scanner scanner = new Scanner(System.in);
        String searchBookText = "----------------------------- SEARCH BOOK -----------------------------\n" +
                "Please choose an option:\n" +
                "1. Search by title\n" +
                "2. Search by author\n" +
                "3. Search by genre\n" +
                "4. Search by ISBN\n" +
                "5. Go back to the menu";
        System.out.println(searchBookText);
    }

    // the searchBooks method: displays the menu for searching books and handles the user's input
    public void searchBooks(){
        Scanner scanner = new Scanner(System.in);

        Boolean exit = false;
        while(!exit)
        {
            introSearchBooks();
            int option = scanner.nextInt();
            switch(option){
                case 1:
                    // Search by title
                    bookService.searchBookByTitle();
                    break;
                case 2:
                    // Search by author
                    bookService.searchBookByAuthor();
                    break;
                case 3:
                    // Search by genre
                    bookService.searchBookByGenre();
                    break;
                case 4:
                    // Search by ISBN
                    bookService.searchBookByISBN();
                    break;
                case 5:
                    // Go back to the menu
                    memberMenu();
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option! Please try again: ");
                    option = scanner.nextInt();
                    break;
            }
        }
    }

    // VIEW ALL BOOKS
    // the introViewAllBooks method: displays the menu for viewing all books
    public void introViewAllBooks(){
        String text = "----------------------------- ALL BOOKS -----------------------------\n" +
                "Please choose an option:\n" +
                "1. View all books sorted by Author\n" +
                "2. View all books sorted by Title\n" +
                "3. View all books sorted by Genre\n" +
                "4. Go back to the menu";
        System.out.println(text);
    }

    public void viewAllBooks(){
        Scanner scanner = new Scanner(System.in);
        Boolean exit = false;

        while(!exit)
        {
            introViewAllBooks();
            int option = scanner.nextInt();

            switch(option){
                case 1:
                    // View all books sorted by Author
                    bookService.viewAllBooksSortedByAuthor();
                    break;
                case 2:
                    // View all books sorted by Title
                    bookService.viewAllBooksSortedByTitle();
                    break;
                case 3:
                    // View all books sorted by Genre
                    bookService.viewAllBooksSortedByGenre();
                    break;
                case 4:
                    // Go back to the menu
                    memberMenu();
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option! Please try again: ");
                    option = scanner.nextInt();
                    break;
            }
        }
    }



    // MEMBER MENU
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
                    searchBooks();
                    break;
                case 5:
                    // View all books
                    viewAllBooks();
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
