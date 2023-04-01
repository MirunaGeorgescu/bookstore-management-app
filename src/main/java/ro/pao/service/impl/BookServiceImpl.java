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
}
