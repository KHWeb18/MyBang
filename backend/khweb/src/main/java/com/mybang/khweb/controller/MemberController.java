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
import java.util.List;
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
                (memberRequest.getAuth().equals("ėŽėė") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        boolean checkId = false;
        checkId = service.checkDuplicateId(memberRequest.getUserId());

        if (checkId == true) {
            log.info("success");
            log.info(memberRequest.getUserId());
            service.register(memberRequest);
            return new ResponseEntity<Boolean>(HttpStatus.OK);
        } else {
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
            // ėļė í ëđ
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

    // --------------------------------------------------------------------------------------------

    // ę°ėę°ëĨí ėėīëėļė§ íėļíęļ°
    @PostMapping("/checkId/{userId}")
    public ResponseEntity<Boolean> checkId(@PathVariable("userId") String userId) throws Exception {
        log.info("Check Id");

        Boolean isSuccess = service.checkDuplicateId(userId);

        return new ResponseEntity<>(isSuccess, HttpStatus.OK);
    }

    // ėīëĐėž ėļėĶíęļ°
    @PostMapping("/checkEmail/{email}")
    public ResponseEntity<String> checkEmail(@PathVariable("email") String email) throws Exception {
        log.info("Check Email");

        String result = service.checkEmail(email);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // ë§ėīíėīė§ íėė ëģī íėļ ė  ëđë°ëēíļ íėļíęļ°
    @PostMapping("/checkPw")
    public ResponseEntity<Boolean> checkPassword(@RequestBody MemberDto memberDto) throws Exception {
        log.info("Check Password");

        Boolean isSuccess = service.checkPassword(memberDto);

        return new ResponseEntity<Boolean>(isSuccess, HttpStatus.OK);
    }

    // ë§ėīíėīė§ íėė ëģī íėļíęļ°
    @GetMapping("/mypage/{userId}")
    public ResponseEntity<Optional<Member>> userInfo(@PathVariable("userId") @RequestBody String userId) throws Exception {

        Optional<Member> result = service.userInfo(userId);

        return new ResponseEntity<Optional<Member>>(result, HttpStatus.OK);
    }

    // ë§ėīíėīė§ íėė ëģī ėė íęļ°
    @PatchMapping("/mypage/modify/{userId}")
    public ResponseEntity<Void> modify(@PathVariable("userId") String userId, @RequestBody MemberDto memberDto) throws Exception {
        Member member = service.findById(userId);

        service.modify(member, memberDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ë§ėīíėīė§ íėííī íęļ°
    @DeleteMapping("/mypage/remove/{userId}")
    public ResponseEntity<Void> remove(@PathVariable("userId") String userId) throws Exception {
        Member member = service.findById(userId);

        service.remove(member);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ėėīë ė°ūęļ°
    @PostMapping("/findingUserId")
    public ResponseEntity<String> findId(@RequestBody MemberDto memberDto) throws Exception {
        String userId = service.findingUserId(memberDto);

        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    // íėėļė§ íėļíęļ°(ëđë°ëēíļ ėŽėĪė  ė )
    @PostMapping("/findingUser")
    public ResponseEntity<String> findUser(@RequestBody MemberDto memberDto) throws Exception {
        String findUser = service.findingUser(memberDto);

        return new ResponseEntity<>(findUser, HttpStatus.OK);
    }

    // ëđë°ëēíļ ėŽėĪė íęļ°(ëđë°ëēíļ ė°ūęļ°)
    @PatchMapping("/modifyPw/{userId}")
    public ResponseEntity<Void> modifyPw(@PathVariable("userId") String userId, @RequestBody MemberDto memberDto) throws Exception {
        Member member = service.findById(userId);

        service.modifyPw(member, memberDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    //íė ëŠĐëĄ ėķë Ĩíęļ°
    @GetMapping("/memberlists")
    public ResponseEntity lists() throws Exception {
        log.info("Member Lists");

        List<Member> members = service.list();

        return new ResponseEntity<>(members, HttpStatus.OK);
    }
    //ęīëĶŽė íėė­ė , ëĪėĪė­ė 
    @DeleteMapping("/remove/{selected}")
    public ResponseEntity<Void> removeMember(@PathVariable("selected") String userId) throws Exception {
        Member member = service.findById(userId);

        service.remove(member);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/pause/{selected}")
    public ResponseEntity<Void> pauseMember(@PathVariable("selected") String userId) throws Exception {
        Member member = service.findById(userId);

        service.pause(member,userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/host/{selected}")
    public ResponseEntity<Void> hostMember(@PathVariable("selected") String userId) throws Exception {
        service.host(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

