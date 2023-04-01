package ro.pao.application;

import ro.pao.model.Book;
import ro.pao.service.impl.BookServiceImpl;
import ro.pao.service.BookService;
import java.util.Scanner;

public class LibrarianMenu {
    private static LibrarianMenu INSTANCE;
    public static LibrarianMenu getInstance() {
        return (INSTANCE == null ? new LibrarianMenu() : INSTANCE);
    }


    private final BookService bookService = new BookServiceImpl();


    // ADDING A NEW BOOK
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


    // REMOVING A BOOK
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



    // VIEW ALL BOOKS
    public void viewAllBooks(){
        String text = "----------------------------- ALL BOOKS -----------------------------\n";
        System.out.println(text);

        for(Book book : bookService.getAllBooks()){
           text = "'" + book.getTitle() + "'" + "\n   by " + book.getAuthor() + "\n";
           System.out.println(text);
        }
    }


    // LIBRARIAN MENU
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
                    viewAllBooks();
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

}
