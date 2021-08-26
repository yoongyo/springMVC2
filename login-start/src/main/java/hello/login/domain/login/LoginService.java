package hello.login.domain.login;


import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password) {
//        Optional<Member> findMemberOptional = memberRepository.findByLoginId(loginId);
//        Member member = findMemberOptional.get();
//
//        if (member.getPassword().equals(password)) {
//            return member;
//        } else {
//            return null;
//        }
        // java 8 stream 으로 간략하게
        return memberRepository.findByLoginId(loginId)
                        .filter(m -> m.getLoginId()
                        .equals(password))
                        .orElse(null);
    }
}
