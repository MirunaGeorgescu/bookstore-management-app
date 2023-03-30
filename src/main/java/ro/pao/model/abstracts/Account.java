package ro.pao.model.abstracts;

import ro.pao.model.enums.AccountStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public abstract class Account extends Person {
    // inherits from AbstractEntity: id, createdDate, updatedDate, deletedDate
    // inherits from Person: name, address, email, phoneNumber
    private String userName;
    private String password;
    private AccountStatus status; // ACTIVE, INACTIVE, BLOCKED
}
