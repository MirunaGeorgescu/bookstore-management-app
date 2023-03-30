package ro.pao.model;

import ro.pao.model.abstracts.AbstractEntity;
import ro.pao.model.abstracts.Account;

public class Review extends AbstractEntity {
    // inherits from AbstractEntity: id, createdDate, updatedDate, deletedDate
    private Integer rating;
    private String comment;
    private Account reviewer;
}
