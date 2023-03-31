package ro.pao.service;

import ro.pao.model.Member;

import java.util.Optional;
import java.util.UUID;

public interface MemberService {
    Optional<Member> getMemberById(UUID id);
}
