package ro.pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.pao.model.abstracts.Account;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Member extends Account {
    // inherits from AbstractEntity: id, createdDate, updatedDate, deletedDate
    // inherits from Person: name, address, email, phoneNumber
    // inherits from Account: userName, password, status
    private LocalDate dateOfMembership;
    private int totalOfBooksBorrowed;

    public Member(String userName, String password, String name, String address, String email, String phoneNumber) {
        super(userName, password, name, address, email, phoneNumber);
        this.dateOfMembership = LocalDate.now();
        this.totalOfBooksBorrowed = 0;
    }
}
