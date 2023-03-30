package ro.pao.model;

import ro.pao.model.abstracts.Account;

import java.time.LocalDate;

public class Member extends Account {
    // inherits from AbstractEntity: id, createdDate, updatedDate, deletedDate
    // inherits from Person: name, address, email, phoneNumber
    // inherits from Account: userName, password, status
    private LocalDate dateOfMembership;
    private int totalOfBooksBrorrowed;
}
