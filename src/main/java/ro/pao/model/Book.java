package ro.pao.model;

import ro.pao.model.enums.BookGenres;

import java.time.LocalDate;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private String publisher;
    private BookGenres genre;
    private Double rating;
    private LocalDate publicationDate;
    private String language;
    private Integer numberOfPages;
    private Double price;
    private Integer totalNumberOfCopies;
    private Integer borrowedNumberOfCopies;

}
