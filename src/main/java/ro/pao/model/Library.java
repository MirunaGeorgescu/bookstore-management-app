package ro.pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.pao.model.abstracts.AbstractEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Library extends AbstractEntity {
    // inherits from AbstractEntity: id, createdDate, updatedDate, deletedDate
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private Catalog catalog;
}
