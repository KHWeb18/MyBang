package com.mybang.khweb.service;

import com.mybang.khweb.entity.Member;
import com.mybang.khweb.entity.MemberAuth;
import com.mybang.khweb.repository.MemberAuthRepository;
import com.mybang.khweb.repository.MemberRepository;
import com.mybang.khweb.request.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
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
    public boolean register(MemberDto memberDto) throws Exception {
        // Repository 쿼리부분을 연결해주는 코드 작성
        List<Member> emailConfirm = repository.findByEmailCheck(memberDto.getEmail());

        if (!emailConfirm.isEmpty()) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }

        String encodedPassword = encoder.encode(memberDto.getPassword());
        memberDto.setPassword(encodedPassword);

        String encodedPasswordConfirm = encoder.encode(memberDto.getPasswordConfirm());
        memberDto.setPasswordConfirm(encodedPasswordConfirm);

        MemberAuth authEntity = new MemberAuth(memberDto.getAuth());
        Member memberEntity = new Member(memberDto.getEmail(), memberDto.getUserName(),
                memberDto.getPassword(), memberDto.getPasswordConfirm());

        memberEntity.addAuth(authEntity);

        repository.save(memberEntity);

        return true;
    }
    // 아이디 찾기
    @Override
    public String findId(HttpServletResponse response, String email) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = manager.findId(email);

        if (id == null) {
            out.println("<script>");
            out.println("alert('가입된 아이디가 없습니다.');");
            out.println("history.go(-1);");
            out.println("</script>");
            out.close();
            return null;
        } else {
            return id;
        }
    }
}
