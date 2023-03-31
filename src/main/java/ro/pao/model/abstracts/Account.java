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
    protected String userName;

    protected String password;

    protected AccountStatus status; // ACTIVE, INACTIVE, BLOCKED

    public Account(String userName, String password, String name, String address, String email, String phoneNumber) {
        super(name, address, email, phoneNumber);
        this.userName = userName;
        this.password = password;
        this.status = AccountStatus.ACTIVE;
    }
}
