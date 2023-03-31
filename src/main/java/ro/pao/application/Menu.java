package ro.pao.application;

import ro.pao.service.LibrarianService;
import ro.pao.service.MemberService;
import ro.pao.service.impl.LibrarianServiceImpl;
import ro.pao.service.impl.MemberServiceImpl;

public class Menu {
    private static Menu INSTANCE;
    private final MemberService memberService = new MemberServiceImpl();
    private final LibrarianService librarianService = new LibrarianServiceImpl();

    public static Menu getInstance(){
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void intro(){
        String intro = "Welcome to the Library!\n" +
                "Please choose an option:\n" +
                "1. Login as a member\n" +
                "2. Login as a librarian\n" +
                "3. Make a new member account\n" +
                "4. Make a new librarian account\n" +
                "5. Exit";
        System.out.println(intro);
    }
}
