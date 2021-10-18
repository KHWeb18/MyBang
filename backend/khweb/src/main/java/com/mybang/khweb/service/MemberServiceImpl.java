package com.mybang.khweb.service;

import com.mybang.khweb.entity.Member;
import com.mybang.khweb.entity.MemberAuth;
import com.mybang.khweb.repository.MemberAuthRepository;
import com.mybang.khweb.repository.MemberRepository;
import com.mybang.khweb.request.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Lazy
@Slf4j
public class MemberServiceImpl implements MemberService{


    @Autowired
    private MemberRepository repository;

    @Autowired
    private MemberAuthRepository authRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void register(MemberRequest memberRequest) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(memberRequest.getUserId(), memberRequest.getPassword());
        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);
    }

    @Override
    public boolean checkUserIdValidation(String UserId) throws Exception {
        Optional<Member> maybeMember = memberRepository.findByUserId(userId);

        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        return true;
    }


    @Override
    public boolean checkDuplicateId(String UserId) throws Exception {
        Optional<Member> checkmember = memberRepository.findByUserId(userId);
        if (checkmember == null) {
            log.info("가입가능한 아이디입니다");

            return false;
        }
        return true;


    }

    @Override
    public Optional<Member> findByAuth(Long memberNo) {
        return memberRepository.findByAuth(memberNo);
    }



    @Override
    public Member signup(MemberDto memberDto) throws Exception {
        String encodedPassword = encoder.encode(memberDto.getPassword());
        memberDto.setPassword(encodedPassword);

        Member member = repository.save(memberDto.toEntity());

        return member;
    }

    @Override
    public Boolean checkPassword(MemberDto memberDto) throws Exception {
        Optional<Member> checkMember = repository.findById(memberDto.getUserId());

        String memberPassword = checkMember.get().getPassword();

        if(!encoder.matches(memberDto.getPassword(), memberPassword)) {
            log.info("fail pw");
            return false;
        }

        log.info("success pw");
        return true;
    }

    @Override
    public Optional<Member> userInfo(String userId) throws Exception {
        return repository.findById(userId);
    }

//    @Override
//    public Member findById(String userId) throws Exception {
//        Member member = repository.findById(userId).orElseThrow();
//
//        return member;
//    }

    @Override
    public void modify(Member member, MemberDto memberDto) throws Exception {
        String encodedPassword = encoder.encode(memberDto.getPassword());
        memberDto.setPassword(encodedPassword);

        member.modifyMember(memberDto);


        repository.save(member);
    }

}
