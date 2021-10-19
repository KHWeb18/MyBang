package com.mybang.khweb.service;

import com.mybang.khweb.entity.Member;
import com.mybang.khweb.request.MemberRequest;

import java.util.Optional;

public interface MemberService {
    public void register(MemberRequest memberRequest) throws Exception;

    public MemberRequest login(MemberRequest memberRequest) throws Exception;

    public boolean checkUserIdValidation(String UserId) throws Exception;

    public boolean checkDuplicateId(String UserId) throws Exception;





    public Optional<Member> findByAuth(Long memberNo);



}