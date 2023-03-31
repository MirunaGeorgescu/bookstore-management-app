package ro.pao.service.impl;

import ro.pao.model.Librarian;
import ro.pao.service.LibrarianService;

import java.util.*;

public class LibrarianServiceImpl implements LibrarianService {
    private Set<Librarian> librarians = new HashSet<>();

    @Override
    public Optional<Librarian> getLibrarianById(UUID id){
        return librarians
                .stream()
                .filter(librarian -> librarian.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Librarian> getLibrarianByUserName(String userName){
        return librarians
                .stream()
                .filter(librarian -> librarian.getUserName().equals(userName))
                .findFirst();
    }

    @Override
    public List<Librarian> getAllLibrarians(){
        return new ArrayList<>(librarians);
    }

    @Override
    public void addLibrarian(Librarian librarian){
        librarians.add(librarian);
    }

    @Override
    public void addLibrarians(List<Librarian> librariansList){
        librarians.addAll(librariansList);
    }

    @Override
    public void deleteLibrarianById(UUID id){
        librarians
                .stream()
                .filter(librarian -> librarian.getId().equals(id))
                .findFirst()
                .ifPresent(librarians::remove);
    }

    @Override
    public void deleteLibrarianByUserName(String userName){
        librarians
                .stream()
                .filter(librarian -> librarian.getUserName().equals(userName))
                .findFirst()
                .ifPresent(librarians::remove);
    }



}
