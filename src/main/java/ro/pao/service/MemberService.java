package ro.pao.service;

import ro.pao.model.Member;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberService {
    Optional<Member> getMemberById(UUID id);

    List<Member> gettAllMembers();

    Optional<Member> getMemberByUserName(String userName);

    void addMember(Member member);

    void addMembers(List<Member> membersList);

}
