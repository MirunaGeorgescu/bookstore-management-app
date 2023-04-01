package ro.pao.service.impl;

import ro.pao.model.Member;
import ro.pao.service.MemberService;

import javax.swing.text.html.Option;
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
    public List<Member> gettAllMembers(){
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

    public void viewAllMembers(){
        String viewAllMembersText = "----------------------------- VIEW ALL MEMBERS -----------------------------";
        System.out.println(viewAllMembersText);

        List<Member> membersList = gettAllMembers();
        if(membersList.isEmpty()){
            System.out.println("There are no members in the database!");
        } else {
            for(Member member : membersList){
                printMember(member);
            }
        }
    }
}
