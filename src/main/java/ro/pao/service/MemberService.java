package ro.pao.service;

import ro.pao.model.Member;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberService {
    Optional<Member> getMemberById(UUID id);

    Optional<Member> getMemberByUserName(String userName);

    List<Member> gettAllMembers();

    void addMember(Member member);

    void addMembers(List<Member> membersList);

    void deleteMemberById(UUID id);

    void deleteMemberByUserName(String userName);

}
