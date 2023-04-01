package ro.pao.application;

import ro.pao.service.LibrarianService;
import ro.pao.service.MemberService;
import ro.pao.service.impl.LibrarianServiceImpl;
import ro.pao.service.impl.MemberServiceImpl;

public class Database {
    private static Database INSTANCE;
    private final MemberService memberService = new MemberServiceImpl();

    private final LibrarianService librarianService = new LibrarianServiceImpl();

    public static Database getInstance(){
        return (INSTANCE == null ? new Database() : INSTANCE);
    }

    public void populateDatabase() {
        memberService.populateMemberDatabase();
        librarianService.populateLibrarianDatabase();
    }
}
