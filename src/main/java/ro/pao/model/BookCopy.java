package ro.pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.pao.model.enums.BookFormat;
import ro.pao.model.enums.BookStatus;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookCopy extends Book {
    // inherits from AbstractEntity: id, createdDate, updatedDate, deletedDate
    // inherits from Book: ISBN, title, author, publisher, genre, rating, publicationDate, language, numberOfPages, price, totalNumberOfCopies, borrowedNumberOfCopies
    private String barcode;
    private BookFormat format; // HARDCOVER, PAPERBACK, EBOOK, AUDIOBOOK
    private BookStatus status; // AVAILABLE, BORROWED, LOST
    private LocalDate borrowedDate;
    private LocalDate dueDate;
    private LocalDate returnedDate;
}
