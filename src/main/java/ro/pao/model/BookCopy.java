package ro.pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.pao.model.enums.BookFormat;
import ro.pao.model.enums.BookGenres;
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

    public void setFormat(String format) {
        if(format == "HARDCOVER"){
            this.format = BookFormat.HARDCOVER;
        } else if(format == "PAPERBACK"){
            this.format = BookFormat.PAPERBACK;
        } else if(format == "EBOOK"){
            this.format = BookFormat.EBOOK;
        } else if(format == "AUDIOBOOK"){
            this.format = BookFormat.AUDIOBOOK;
        }
    }

    public void setStatus(String status) {
        if(status == "AVAILABLE"){
            this.status = BookStatus.AVAILABLE;
        } else if(status == "BORROWED"){
            this.status = BookStatus.BORROWED;
        } else if(status == "LOST"){
            this.status = BookStatus.LOST;
        }
    }
}
