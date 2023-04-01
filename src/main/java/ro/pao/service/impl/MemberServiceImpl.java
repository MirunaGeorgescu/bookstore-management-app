package ro.pao.service.impl;

import ro.pao.model.Member;
import ro.pao.service.MemberService;

import java.util.*;

public class MemberServiceImpl implements MemberService {
    private static Set<Member> members = new HashSet<>();


    //GETTERS
    @Override
    public Optional<Member> getMemberById(UUID id){
        return members
                .stream()
                .filter(member -> member.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Member> getMemberByUserName(String userName){
        return members
                .stream()
                .filter(member -> member.getUserName().equals(userName))
                .findFirst();
    }

    @Override
    public Optional<Member> getMemberByEmail(String email){
        return members
                .stream()
                .filter(member -> member.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public Optional<Member> getMemberByPhoneNumber(String phoneNumber){
        return members
                .stream()
                .filter(member -> member.getPhoneNumber().equals(phoneNumber))
                .findFirst();
    }

    @Override
    public List<Member> getAllMembers(){
        return new ArrayList<>(members);
    }



    // ADDDING
    @Override
    public void addMember(Member member){
        members.add(member);
    }

    @Override
    public void addMembers(List<Member> membersList){
        members.addAll(membersList);
    }

    @Override
    public void createMember(String username, String password, String name, String address, String email, String phoneNumber){
        Member member = new Member(username, password, name, address, email, phoneNumber);
        members.add(member);
    }




    //DELETING
    @Override
    public void deleteMemberById(UUID id){
        members
                .stream()
                .filter(member -> member.getId().equals(id))
                .findFirst()
                .ifPresent(members::remove);
    }

    @Override
    public void deleteMemberByUserName(String userName){
        members
                .stream()
                .filter(member -> member.getUserName().equals(userName))
                .findFirst()
                .ifPresent(members::remove);
    }


    // VALIDATIONS
    // the isMember method: checks if the username and password are correct
    @Override
    public Boolean isMember(String userName, String password){
        if(members .stream()
                .filter(member -> member.getUserName().equals(userName))
                .findFirst()
                .isPresent()) {
            Optional<Member> currentMember = members
                    .stream()
                    .filter(member -> member.getUserName().equals(userName))
                    .findFirst();

            if(currentMember.get().getPassword().equals(password)){
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




    // the populateMemberDatabase method: adds members to the "database"
    @Override
    public void populateMemberDatabase(){
        Member member = new Member("user1", "user1", "Daria Chiriac", "Strada A", "kiri@mail.com", "074353627364");
        members.add(member);
    }


    // PRINTING INFO
    @Override
    public void printMember(Member member){
        String text = "Member: " + member.getName() + "\n"+
                "Username: " + member.getUserName() + "\n" +
                "Email: " + member.getEmail() + "\n";
        System.out.println(text);
    }

    @Override
    public void printMemberDetails(Member member){
        String text = "Member: " + member.getName() + "\n"+
                "Username: " + member.getUserName() + "\n" +
                "Email: " + member.getEmail() + "\n" +
                "Address: " + member.getAddress() + "\n" +
                "Phone number: " + member.getPhoneNumber() + "\n";
        System.out.println(text);
    }

    // the viewAllMembers method: prints the name, username and email of all members
    public void viewAllMembers(){
        String viewAllMembersText = "----------------------------- VIEW ALL MEMBERS -----------------------------";
        System.out.println(viewAllMembersText);

        List<Member> membersList = getAllMembers();
        if(membersList.isEmpty()){
            System.out.println("There are no members in the database!");
        } else {
            for(Member member : membersList){
                printMember(member);
            }
        }
    }



    // SEARCHING
    public void searchMemberByUsername(){
        String searchMemberByUsernameText = "----------------------------- SEARCH MEMBER BY USERNAME -----------------------------";
        System.out.println(searchMemberByUsernameText);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username of the member you want to search for: ");
        String username = scanner.nextLine();

        Optional<Member> member = getMemberByUserName(username);
        if(member.isPresent()){
            System.out.println("Member found!");
            printMember(member.get());
        } else {
            System.out.println("There is no member with the username " + username + " in the database!");
        }
    }

    @Override
    public void searchMemberByEmail(){
        String searchMemberByEmailText = "----------------------------- SEARCH MEMBER BY EMAIL -----------------------------";
        System.out.println(searchMemberByEmailText);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the email of the member you want to search for: ");
        String email = scanner.nextLine();

        Optional<Member> member = getMemberByEmail(email);
        if(member.isPresent()){
            System.out.println("Member found!");
            printMember(member.get());
        } else {
            System.out.println("There is no member with the email " + email + " in the database!");
        }
    }

    @Override
    public void searchMemberByPhoneNumber(){
        String searchMemberByPhoneNumberText = "----------------------------- SEARCH MEMBER BY PHONE NUMBER -----------------------------";
        System.out.println(searchMemberByPhoneNumberText);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the phone number of the member you want to search for: ");
        String phoneNumber = scanner.nextLine();

        Optional<Member> member = getMemberByPhoneNumber(phoneNumber);
        if(member.isPresent()){
            System.out.println("Member found!");
            printMember(member.get());
        } else {
            System.out.println("There is no member with the phone number " + phoneNumber + " in the database!");
        }
    }
}
