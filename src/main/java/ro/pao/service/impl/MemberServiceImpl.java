package ro.pao.service.impl;

import ro.pao.model.Member;
import ro.pao.service.MemberService;

import javax.swing.text.html.Option;
import java.util.*;

public class MemberServiceImpl implements MemberService {
    private Set<Member> members = new HashSet<>();

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

    @Override
    public void addMember(Member member){
        members.add(member);
    }

    @Override
    public void addMembers(List<Member> membersList){
        members.addAll(membersList);
    }

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

    @Override
    public void createMember(String username, String password, String name, String address, String email, String phoneNumber){
        Member member = new Member(username, password, name, address, email, phoneNumber);
        members.add(member);
    }

}
