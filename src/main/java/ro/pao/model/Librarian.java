package ro.pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.pao.model.abstracts.Account;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Librarian extends Account {
    // inherits from AbstractEntity: id, createdDate, updatedDate, deletedDate
    // inherits from Person: name, address, email, phoneNumber
    // inherits from Account: userName, password, status
}
