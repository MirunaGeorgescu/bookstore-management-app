package ro.pao.application;

import ro.pao.model.Book;
import ro.pao.model.BookCopy;
import ro.pao.model.Member;
import ro.pao.model.enums.BookStatus;
import ro.pao.service.BookService;
import ro.pao.service.MemberService;
import ro.pao.service.impl.BookServiceImpl;
import ro.pao.service.impl.MemberServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MemberMenu {
    private static MemberMenu INSTANCE;
    public static MemberMenu getInstance() {
        return (INSTANCE == null ? new MemberMenu() : INSTANCE);
    }



    private final BookService bookService = new BookServiceImpl();
    private final MemberService memberService = new MemberServiceImpl();



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
    public void searchBooks(String username){
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
                    memberMenu(username);
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

    public void viewAllBooks(String username){
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
                    memberMenu(username);
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option! Please try again: ");
                    option = scanner.nextInt();
                    break;
            }
        }
    }




    // BORROWING BOOKS
    void viewBorrowedBooks(String username){
        String text = "------------------------------------ BORROWED BOOKS ------------------------------------\n";
        System.out.println(text);

        Optional<Member> member = memberService.getMemberByUserName(username);
        Member currentMember = member.get();

        List<BookCopy> borrowedBooks = currentMember.getBorrowedBooks();
        if(borrowedBooks.isEmpty()){
            System.out.println("You haven't borrowed any books yet!\n");
        } else {
            System.out.println("You have borrowed the following books: ");
            for(BookCopy bookCopy : borrowedBooks){
                System.out.println(bookCopy.getTitle());
            }
        }

    }

    void borrowBook(String username){
        Scanner scanner = new Scanner(System.in);

        String text = "------------------------------------ BORROW BOOK ------------------------------------";
        System.out.println(text);

        Member currentMember = memberService.getMemberByUserName(username).get();
        List<BookCopy> borrowedBooks = currentMember.getBorrowedBooks();
        if(borrowedBooks.size() == 5){
            System.out.println("You have reached the maximum number of books you can borrow! Please return a book before borrowing another one.\n");
        } else{
            text = "Please enter the title of the book you want to borrow: ";
            System.out.println(text);
            String title = scanner.nextLine();

            Optional<Book> book = bookService.getBookByTitle(title);
            if(!book.isPresent()){
                System.out.println("There is no book with this title in the library!\n");
            } else {
                Book currentBook = book.get();

                if(currentBook.getTotalNumberOfCopies() - currentBook.getBorrowedNumberOfCopies() == 0){
                    System.out.println("There are no copies of this book available for borrowing!\n");
                } else{

                    List<BookCopy> bookCopies = currentBook.getBookCopies();
                    for(BookCopy bookCopy: bookCopies){
                        if(bookCopy.getStatus().toString().equalsIgnoreCase("AVAILABLE")){
                            // set the status of the book copy to BORROWED
                            bookCopy.setStatus("BORROWED");
                            bookCopy.setBorrowedDate(LocalDate.now());
                            bookCopy.setDueDate(LocalDate.now().plusDays(30));
                            currentBook.setBorrowedNumberOfCopies(currentBook.getBorrowedNumberOfCopies() + 1);

                            // add the book copy to the list of borrowed books of the current member
                            currentMember.getBorrowedBooks().add(bookCopy);
                            System.out.println("You have successfully borrowed the book: " + bookCopy.getTitle() + "\n");
                            break;
                        }
                    }
                }
            }
        }







    }


    // MEMBER MENU
    // the introMemberMenu: displays the menu for the members
    public void introMemberMenu(String username){
        String intro = "----------------------------- Welcome back, "+ memberService.getMemberNameByUserName(username)+"! ------------------------------\n" +
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
    public void memberMenu(String username){
        Scanner scanner = new Scanner(System.in);
        Boolean exit = false;

        while(!exit)
        {
            introMemberMenu(username);
            int option = scanner.nextInt();

            switch(option){
                case 1:
                    // Borrow a book
                    borrowBook(username);
                    break;
                case 2:
                    // Return a book
                    break;
                case 3:
                    // View borrowed books
                    viewBorrowedBooks(username);
                    break;
                case 4:
                    // Search for a book
                    searchBooks(username);
                    break;
                case 5:
                    // View all books
                    viewAllBooks(username);
                    break;
                case 6:
                    // 6. Log out
                    System.out.println("See you next time!\nLogging out...\n");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option!\nPlease try again:");
                    option = scanner.nextInt();
                    break;
            }
        }
    }
}
