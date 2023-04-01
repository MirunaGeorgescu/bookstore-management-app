package ro.pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.pao.model.abstracts.AbstractEntity;
import ro.pao.model.enums.BookGenres;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Book  extends AbstractEntity {
    // inherits from AbstractEntity: id, createdDate, updatedDate, deletedDate
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

    private List<BookCopy> bookCopies;


    public Book(String ISBN, String title, String author, String publisher, String genre, String publicationDate,
                String language, Integer numberOfPages, Double price, Integer totalNumberOfCopies) {
        super();
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.rating = 0.0; // the rating for a new bool is 0.0, since it has no reviews yet
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.totalNumberOfCopies = totalNumberOfCopies;
        this.borrowedNumberOfCopies = 0;

        if(genre.equalsIgnoreCase("FANTASY")){
            this.genre = BookGenres.FANTASY;
        } else if(genre.equalsIgnoreCase("ROMANCE")){
            this.genre = BookGenres.ROMANCE;
        } else if(genre.equalsIgnoreCase("SCIENCE_FICTION")){
            this.genre = BookGenres.SCIENCE_FICTION;
        } else if(genre == "LITERARY_FICTION"){
            this.genre = BookGenres.LITERARY_FICTION;
        } else if(genre.equalsIgnoreCase("HORROR")){
            this.genre = BookGenres.HORROR;
        } else if(genre.equalsIgnoreCase("MYSTERY")){
            this.genre = BookGenres.MYSTERY;
        } else if(genre.equalsIgnoreCase("THRILLER")){
            this.genre = BookGenres.THRILLER;}

        //formatting the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        this.publicationDate = LocalDate.parse(publicationDate, formatter); // convert String to LocalDate

        // adding the book copies
        bookCopies = new ArrayList<>();
        for(int i = 0; i < totalNumberOfCopies; i++){
            BookCopy bookCopy = new BookCopy();

            bookCopy.setISBN(ISBN);
            bookCopy.setTitle(title);
            bookCopy.setAuthor(author);
            bookCopy.setPublisher(publisher);
            bookCopy.setGenre(this.genre);
            bookCopy.setRating(0.0);
            bookCopy.setPublicationDate(this.publicationDate);
            bookCopy.setLanguage(language);
            bookCopy.setNumberOfPages(numberOfPages);
            bookCopy.setPrice(price);
            bookCopy.setTotalNumberOfCopies(totalNumberOfCopies);
            bookCopy.setBorrowedNumberOfCopies(0);

            bookCopy.setBarcode(ISBN + "-" + (i+1));
            bookCopy.setFormat("PAPERBACK");
            bookCopy.setStatus("AVAILABLE");
            bookCopy.setBorrowedDate(null);
            bookCopy.setDueDate(null);
            bookCopy.setReturnedDate(null);

            bookCopies.add(bookCopy);
        }
    }


}
