package ro.pao.application;

import ro.pao.service.LibrarianService;
import ro.pao.service.MemberService;
import ro.pao.service.impl.LibrarianServiceImpl;
import ro.pao.service.impl.MemberServiceImpl;
import ro.pao.service.BookService;
import ro.pao.service.impl.BookServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    private static Database INSTANCE;

    public static Database getInstance(){
        return (INSTANCE == null ? new Database() : INSTANCE);
    }

    //SIMULATING A DATABASE
    private final MemberService memberService = new MemberServiceImpl();

    private final LibrarianService librarianService = new LibrarianServiceImpl();

    private final BookService bookService = new BookServiceImpl();

    public void populateDatabase() {
        memberService.populateMemberDatabase();
        librarianService.populateLibrarianDatabase();
        bookService.populateBookDatabase();
    }

}
