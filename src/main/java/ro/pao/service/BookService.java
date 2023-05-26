package ro.pao.service;

import ro.pao.model.Book;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface BookService {
  // GETTERS
  Optional<Book> getBookById(UUID id);
  Optional<Book> getBookByISBN(String ISBN);
  Optional<Book> getBookByTitle(String title);
  List<Book> getAllBooks();
  List<Book> getBookByAuthor(String author);


  // ADDING BOOKS
  void addBook(Book book);
  void addBooks(List<Book> booksList);


  // DELETING BOOKS
  void deleteBookById(UUID id);
  void deleteBookByISBN(String ISBN);


  // DATA BASE
  void populateBookDatabase();

  // SEARCHING BOOKS
  void searchBookByTitle();
  void searchBookByISBN();
  void searchBookByAuthor();
  void searchBookByGenre();


  // PRINT METHODS
  void printBook(Book book);
  void printBookDetails(Book book);

  // VALIDATION METHODS
  Boolean bookGenreValidation(String genre);

  // SORTING METHODS
  void viewAllBooks();
  void viewAllBooksSortedByAuthor();
  void viewAllBooksSortedByTitle();
  void viewAllBooksSortedByGenre();
}
