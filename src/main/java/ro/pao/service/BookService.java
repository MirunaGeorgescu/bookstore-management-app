package ro.pao.service;

import ro.pao.model.Book;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface BookService {
  Optional<Book> getBookById(UUID id);

  Optional<Book> getBookByISBN(String ISBN);

  Optional<Book> getBookByTitle(String title);

  List<Book> getAllBooks();

  void addBook(Book book);

  void addBooks(List<Book> booksList);

  void deleteBookById(UUID id);

  void deleteBookByISBN(String ISBN);

  void populateBookDatabase();

  void searchBookByTitle();

  void printBook(Book book);

  void printBookDetails(Book book);

  void searchBookByISBN();

  void searchBookByAuthor();

  List<Book> getBookByAuthor(String author);

  void searchBookByGenre();

  Boolean bookGenreValidation(String genre);

  void viewAllBooksSortedByAuthor();

  void viewAllBooksSortedByTitle();

  void viewAllBooksSortedByGenre();


}
