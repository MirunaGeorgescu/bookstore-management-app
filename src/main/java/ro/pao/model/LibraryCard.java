package ro.pao.model;

import ro.pao.model.abstracts.AbstractEntity;

import java.time.LocalDate;

public class LibraryCard extends AbstractEntity {
    // inherits from AbstractEntity: id, createdDate, updatedDate, deletedDate
    private int cardNumber;
    private LocalDate issuedAt;
    private Boolean active;
}
