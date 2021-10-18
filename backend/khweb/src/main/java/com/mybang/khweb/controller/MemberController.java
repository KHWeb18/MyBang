package com.mybang.khweb.controller;

import com.mybang.khweb.controller.session.UserInfo;
import com.mybang.khweb.entity.Member;
import com.mybang.khweb.request.MemberDto;
import com.mybang.khweb.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.List;

import java.util.Optional;



@Controller
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j

public class MemberController {

    private UserInfo info;

    @Autowired
    private MemberService service;


    private HttpSession session;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody MemberDto memberDto) throws Exception {
        log.info("Member Signup");

        Member member = service.signup(memberDto);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

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


    @PostMapping("/register")
    public Object jpaRegister(
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



}
