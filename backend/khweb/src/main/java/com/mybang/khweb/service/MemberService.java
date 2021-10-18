package com.mybang.khweb.service;

import com.mybang.khweb.entity.Member;
import com.mybang.khweb.request.MemberDto;

import java.util.Optional;



public interface MemberService {
    Member signup(MemberDto memberDto) throws Exception;
    Boolean checkPassword(MemberDto memberDto) throws Exception;
    Optional<Member> userInfo(String userId) throws Exception;
    //Member findById(String userId) throws Exception;
    void modify(Member member, MemberDto memberDto) throws Exception;


    public void register(MemberRequest memberRequest) throws Exception;

    public boolean checkUserIdValidation(String UserId) throws Exception;

    public boolean checkDuplicateId(String UserId) throws Exception;

    public Optional<Member> findByAuth(Long memberNo);
}
