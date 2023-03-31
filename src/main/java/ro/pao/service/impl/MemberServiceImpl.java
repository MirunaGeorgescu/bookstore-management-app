package ro.pao.service.impl;

import ro.pao.model.Member;
import ro.pao.service.MemberService;

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

    public void addMembers(List<Member> membersList){
        members.addAll(membersList);
    }




}
