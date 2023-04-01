package ro.pao.service.impl;

import ro.pao.model.Book;
import ro.pao.service.BookService;

import java.util.*;

public class BookServiceImpl implements BookService {
    public static Set<Book> books = new HashSet<>();

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

    @Override
    public List<Book> getAllBooks(){
        return new ArrayList<>(books);
    }

    @Override
    public void addBook(Book book){
        books.add(book);
    }

    @Override
    public void addBooks(List<Book> booksList){
        books.addAll(booksList);
    }

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

    // the populateBookDatabase method: adds books to the "database"
    @Override
    public void populateBookDatabase(){
        // A man called Ove
        Book book1 = new Book("9781444775808", "A Man Called Ove", "Fredrik Backman", "Atria Books",
                "literary_fiction", "11/07/2014", "English", 353, 10.00,
                5);
        addBook(book1);

        // The Shining
        Book book2 = new Book("9780450040184", "The Shining", "Stephen King",
                "New English Library (Hodder & Stoughton)", "horror", "01/07/1980",
                "English", 447, 10.00, 5);
        addBook(book2);
    }

}
