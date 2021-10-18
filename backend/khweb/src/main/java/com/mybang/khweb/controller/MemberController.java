package com.mybang.khweb.controller;

import com.mybang.khweb.controller.session.UserInfo;
import com.mybang.khweb.entity.MemberAuth;
import com.mybang.khweb.request.MemberDto;
import com.mybang.khweb.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public ResponseEntity<Boolean> jpaRegister(
            @Validated @RequestBody MemberDto memberDto) throws Exception {
        log.info("jpaRegister(): " + memberDto.getEmail() + ", " + memberDto.getUserName()
                + ", " + memberDto.getPassword() + ", " + memberDto.getPasswordConfirm());

        service.register(memberDto);

        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }


    // 아이디 찾기
    @RequestMapping("/findIdForm.do")
    public String findIdForm() throws Exception{
        return "/findIdForm";

    // 아이디 찾기
    @RequestMapping(value = "/findId.do", method = RequestMethod.POST)
    public String findId(HttpServletResponse response, @RequestParam("email") String email, Model md) throws Exception{
        md.addAttribute("id", service.findId(response, email));
        return "/findId";
    }
}
