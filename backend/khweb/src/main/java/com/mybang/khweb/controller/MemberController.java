package com.mybang.khweb.controller;

import com.mybang.khweb.controller.session.UserInfo;
import com.mybang.khweb.entity.Member;
import com.mybang.khweb.request.MemberDto;
import com.mybang.khweb.request.MemberRequest;
import com.mybang.khweb.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class MemberController {

    @Autowired
    private MemberService service;

    private UserInfo info;

    private HttpSession session;

    @PostMapping("/register")
    public Object Register(
            @Validated @RequestBody MemberRequest memberRequest) throws Exception {
        log.info("jpaRegister(): " + memberRequest.getUserId() + ", " + memberRequest.getPassword() + ", " +
                (memberRequest.getAuth().equals("사업자") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        boolean checkId = false;
        checkId = service.checkDuplicateId(memberRequest.getUserId());

        if(checkId == true) {
            log.info("success");
            log.info(memberRequest.getUserId());
            service.register(memberRequest);
            return new ResponseEntity<Boolean>(HttpStatus.OK);
        }else {
            log.info("duuplicate");
            log.info(memberRequest.getUserId());
            return false;
        }

    }

    @PostMapping("/login")
    public ResponseEntity<UserInfo> jpaLogin(
            @RequestBody MemberRequest memberRequest,
            HttpServletRequest request
    ) throws Exception {

        log.info("jpaLogin() - userId: " + memberRequest.getUserId() + ", password: " + memberRequest.getPassword());

        MemberRequest memberResponse = service.login(memberRequest);

        if (!memberResponse.equals(null)) {
            log.info("Login Success");
            // 세션 할당
            info = new UserInfo();
            info.setUserId(memberResponse.getUserId());
            info.setAuth(memberResponse.getAuth());
            log.info("Session Info: " + info);

            session = request.getSession();
            session.setAttribute("member", info);
        } else {
            log.info("Login Failure");
            info = null;
        }

        return new ResponseEntity<UserInfo>(info, HttpStatus.OK);

    }

    // -- 회원정보 확인, 수정, 탈퇴, 아이디찾기, 비밀번호찾기(변경) --
    @PostMapping("/checkPw")
    public ResponseEntity<Boolean> checkPassword(@RequestBody MemberDto memberDto) throws Exception {
        log.info("Check Password");

        Boolean isSuccess = service.checkPassword(memberDto);

        return new ResponseEntity<Boolean>(isSuccess, HttpStatus.OK);
    }

    @GetMapping("/mypage/{userId}")
    public ResponseEntity<Optional<Member>> userInfo(@PathVariable("userId") @RequestBody String userId) throws Exception {

        Optional<Member> result = service.userInfo(userId);

        return new ResponseEntity<Optional<Member>>(result, HttpStatus.OK);
    }

    @PatchMapping("/mypage/modify/{userId}")
    public ResponseEntity<Void> modify(@PathVariable("userId") String userId, @RequestBody MemberDto memberDto) throws Exception {
        Member member = service.findById(userId);

        service.modify(member, memberDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/mypage/remove/{userId}")
    public ResponseEntity<Void> remove(@PathVariable("userId") String userId) throws Exception {
        Member member = service.findById(userId);

        service.remove(member);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/findingUserId")
    public ResponseEntity<String> findId(@RequestBody MemberDto memberDto) throws Exception {
        String userId = service.findingUserId(memberDto);

        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @PostMapping("/findingUser")
    public ResponseEntity<Boolean> findUser(@RequestBody MemberDto memberDto) throws Exception {
        Boolean findUser = service.findingUser(memberDto);

        return new ResponseEntity<>(findUser, HttpStatus.OK);
    }

    @PatchMapping("/modifyPw/{userId}")
    public ResponseEntity<Void> modifyPw(@PathVariable("userId") String userId, @RequestBody MemberDto memberDto) throws Exception {
        Member member = service.findById(userId);

        service.modifyPw(member, memberDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
