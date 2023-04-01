package ro.pao.service;

import ro.pao.model.Member;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberService {
    Optional<Member> getMemberById(UUID id);

    Optional<Member> getMemberByUserName(String userName);
    Optional<Member> getMemberByEmail(String email);

    List<Member> getAllMembers();

    Optional<Member> getMemberByPhoneNumber(String phoneNumber);

    void addMember(Member member);

    void addMembers(List<Member> membersList);

    void deleteMemberById(UUID id);

    void deleteMemberByUserName(String userName);

    // the isMember method: checks if the username and password are correct
    Boolean isMember(String username, String password);

    void createMember(String username, String password, String name, String address, String email, String phoneNumber);

    // the populateMemberDatabase method: adds members to the "database"
    void populateMemberDatabase();

    void printMember(Member member);

    void printMemberDetails(Member member);

    // the viewAllMembers method: prints the name, username and email of all members
    void viewAllMembers();

    // SEARCHING
    void searchMemberByUsername();
    void searchMemberByEmail();
    void searchMemberByPhoneNumber();

}
