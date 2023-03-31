package ro.pao.service;

import ro.pao.model.Librarian;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LibrarianService {
    Optional<Librarian> getLibrarianById(UUID id);

    Optional<Librarian> getLibrarianByUserName(String userName);

    List<Librarian> getAllLibrarians();

    void addLibrarian(Librarian librarian);

    void addLibrarians(List<Librarian> librariansList);

    void deleteLibrarianById(UUID id);

    void deleteLibrarianByUserName(String userName);

    // the isLibrarian method: checks if the username and password are correct
    Boolean isLibrarian(String userName, String password);
}
