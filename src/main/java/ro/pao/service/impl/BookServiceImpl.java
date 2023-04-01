package ro.pao.service.impl;

import ro.pao.model.Book;
import ro.pao.service.BookService;

import java.util.*;

public class BookServiceImpl implements BookService {
    public static Set<Book> books = new HashSet<>();


    // GETTERS
    @Override
    public Optional<Book> getBookById(UUID id){
        return books
                .stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Book> getBookByISBN(String ISBN){
        return books
                .stream()
                .filter(book -> book.getISBN().equals(ISBN))
                .findFirst();
    }

    @Override
    public Optional<Book> getBookByTitle(String title){
        return books
                .stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst();
    }

    public List<Book> getBookByAuthor(String author){
        List<Book> booksByAuthor = new ArrayList<>();

        for(Book book : books){
            if(book.getAuthor().equals(author)){
                booksByAuthor.add(book);
            }
        }

        return booksByAuthor;
    }

    public List<Book> getBookByGenre(String genre){
        List<Book> booksInGenre = new ArrayList<>();

        for(Book book : books){
            if(book.getGenre().toString().equalsIgnoreCase(genre)){
                booksInGenre.add(book);
            }
        }

        return booksInGenre;
    }

    @Override
    public List<Book> getAllBooks(){
        return new ArrayList<>(books);
    }



    // ADDING
    @Override
    public void addBook(Book book){
        books.add(book);
    }

    @Override
    public void addBooks(List<Book> booksList){
        books.addAll(booksList);
    }


    // DELETING
    @Override
    public void deleteBookById(UUID id){
        books
                .stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .ifPresent(books::remove);
    }

    @Override
    public void deleteBookByISBN(String ISBN){
        books
                .stream()
                .filter(book -> book.getISBN().equals(ISBN))
                .findFirst()
                .ifPresent(books::remove);
    }



    // DATABASE
    // the populateBookDatabase method: adds books to the "database"
    @Override
    public void populateBookDatabase(){
        // A man called Ove
        Book book1 = new Book("9781444775808", "A Man Called Ove", "Fredrik Backman", "Atria Books",
                "LITERARY_FICTION", "11/07/2014", "English", 353, 10.00,
                5);
        addBook(book1);

        // The Shining
        Book book2 = new Book("9780450040184", "The Shining", "Stephen King",
                "New English Library (Hodder & Stoughton)", "horror", "01/07/1980",
                "English", 447, 10.00, 5);
        addBook(book2);
    }



    // PRINT BOOK
    @Override
    public void printBook(Book book){
        String text = "'" + book.getTitle() + "'" + "\n   by " + book.getAuthor() + "\n";
        System.out.println(text);
    }

    @Override
    public void printBookDetails(Book book) {
        String text = "----------------------------- BOOK DETAILS -----------------------------\n" +
                "Title: " + book.getTitle() + "\n" +
                "Author: " + book.getAuthor() + "\n" +
                "ISBN: " + book.getISBN() + "\n" +
                "Publisher: " + book.getPublisher() + "\n" +
                "Genre: " + book.getGenre() + "\n" +
                "Publication date: " + book.getPublicationDate() + "\n" +
                "Language: " + book.getLanguage() + "\n" +
                "Number of pages: " + book.getNumberOfPages() + "\n" +
                "Price: " + book.getPrice() + "\n" +
                "Rating: " + book.getRating() + "\n" +
                "Number of copies: " + book.getTotalNumberOfCopies() + "\n" +
                "Number of borrowed copies: " + book.getBorrowedNumberOfCopies() + "\n" +
                "Number of available copies: " + (book.getTotalNumberOfCopies() - book.getBorrowedNumberOfCopies()) + "\n";
        System.out.println(text);
    }


    // VALIDATIONS
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



    // VIEW ALL BOOKS
    @Override
    public void viewAllBooks(){
        String text = "----------------------------- ALL BOOKS -----------------------------\n";
        System.out.println(text);

        for(Book book : getAllBooks()){
           printBook(book);
        }
    }



    // SEARCHING
    // SEARCH BY TITLE
    @Override
    public void searchBookByTitle(){
        Scanner scanner = new Scanner(System.in);
        String searchBookText = "----------------------------- SEARCH BOOK BY TITLE -----------------------------\n" +
                "Please enter the book's title: ";
        System.out.println(searchBookText);

        String title = scanner.nextLine();
        Optional<Book> book = getBookByTitle(title);

        if(book.isPresent()){
            System.out.println("Book found!");
            printBookDetails(book.get());
        } else {
            System.out.println("Book not found!");
        }

    }

    // SEARCH BY ISBN
    @Override
    public void searchBookByISBN(){
        Scanner scanner = new Scanner(System.in);

        String searchBookText = "----------------------------- SEARCH BOOK BY ISBN -----------------------------\n" +
                "Please enter the book's ISBN: ";
        System.out.println(searchBookText);

        String ISBN = scanner.nextLine();
        Optional<Book> book = getBookByISBN(ISBN);

        if(book.isPresent()){
            System.out.println("Book found!");
            printBookDetails(book.get());
        } else {
            System.out.println("Book not found!");
        }
    }

    // SEARCH BY AUTHOR
    @Override
    public void searchBookByAuthor(){
        Scanner scanner = new Scanner(System.in);
        String searchBookText = "----------------------------- SEARCH BOOK BY AUTHOR -----------------------------\n" +
                "Please enter the author's full name: ";
        System.out.println(searchBookText);

        String author = scanner.nextLine();
        List<Book> booksByAuthor = getBookByAuthor(author);

        if(booksByAuthor.isEmpty())
        {
            System.out.println("No books written by " + author + " were found!");
        }else{
            System.out.println("\nAuthor found!\nHere are all the books available written by " + author + ":");
            for(Book book : booksByAuthor){
                System.out.println(book.getTitle());
            }
        }
    }

    // SEARCH BY GENRE
    @Override
    public void searchBookByGenre(){
        Scanner scanner = new Scanner(System.in);
        String searchBookText = "----------------------------- SEARCH BOOK BY GENRE -----------------------------\n" +
                "Please enter the genre: ";
        System.out.println(searchBookText);

        String genre = scanner.nextLine();

        // checking if the genre is valid
        while(!bookGenreValidation(genre)){
            System.out.println("Invalid genre! The options are:\n " +
                    "-> FANTASY\n -> ROMANCE\n -> SCIENCE_FICTION\n -> LITERARY_FICTION\n -> HORROR\n -> MYSTERY\n -> THRILLER\n" +
                    "Please enter a valid genre: ");
            genre = scanner.nextLine();
        }

        List<Book> bookInGenre = getBookByGenre(genre);
        if(bookInGenre.isEmpty()){
            System.out.println("There are no " + genre.toString() + " books! Try something else!");
        } else{
            System.out.println("Genre found!\nHere are all the books in the " + genre.toString().toLowerCase() + " genre:");
            for(Book book : bookInGenre){
                printBook(book);
            }
        }
    }

}
