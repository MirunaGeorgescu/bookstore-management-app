package ro.pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.pao.model.abstracts.AbstractEntity;
import ro.pao.model.abstracts.Account;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Review extends AbstractEntity {
    // inherits from AbstractEntity: id, createdDate, updatedDate, deletedDate
    private Integer rating;
    private String comment;
    private Account reviewer;
}
