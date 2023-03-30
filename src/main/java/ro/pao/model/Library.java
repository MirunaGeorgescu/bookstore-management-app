package ro.pao.model;

import ro.pao.model.abstracts.AbstractEntity;

public class Library extends AbstractEntity {
    // inherits from AbstractEntity: id, createdDate, updatedDate, deletedDate
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private Catalog catalog;
}
