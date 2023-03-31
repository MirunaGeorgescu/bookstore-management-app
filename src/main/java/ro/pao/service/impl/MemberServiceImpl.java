package ro.pao.service.impl;

import ro.pao.model.Member;
import ro.pao.service.MemberService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class MemberServiceImpl implements MemberService {
    private Set<Member> members = new HashSet<>();

    @Override
    public Optional<Member> getMemberById(UUID id){
        return members
                .stream()
                .filter(member -> member.getId().equals(id))
                .findFirst();
    }


}
