package ro.pao.service.impl;

import ro.pao.model.Librarian;
import ro.pao.model.Member;
import ro.pao.service.LibrarianService;

import java.util.*;

public class LibrarianServiceImpl implements LibrarianService {
    private static Set<Librarian> librarians = new HashSet<>();

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

    // the isLibrarian method: checks if the username and password are correct
    @Override
    public Boolean isLibrarian(String userName, String password){
        if( librarians.stream()
                .filter(member -> member.getUserName().equals(userName))
                .findFirst()
                .isPresent()) {
            Optional<Librarian> currentLibrarian = librarians
                    .stream()
                    .filter(member -> member.getUserName().equals(userName))
                    .findFirst();

            if(currentLibrarian.get().getPassword().equals(password)){
                return true;
            } else {
                System.out.println("Wrong password!");
                return false;
            }
        } else {
            System.out.println("Wrong username!");
            return false;
        }
    }

    // the createLibrarian method: creates a new librarian account
    @Override
    public void createLibrarian(String username, String password, String name, String address, String email, String phoneNumber){
        Librarian librarian = new Librarian(username, password, name, address, email, phoneNumber);
        librarians.add(librarian);
    }

    // the populateLibrarianDatabase method: adds librarians to the "database"
    @Override
    public void populateLibrarianDatabase(){
        Librarian librarian = new Librarian("librarian1", "librarian1", "Andreea Ciocan", "Str. B", "cioucan@mail.com", "0762423424");
        librarians.add(librarian);
    }
}
