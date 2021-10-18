package com.mybang.khweb.service;

import com.mybang.khweb.request.MemberDto;

import javax.servlet.http.HttpServletResponse;


public interface MemberService {

    public boolean register(MemberDto memberDto) throws Exception;

    // 아이디 찾기
    public String findId(HttpServletResponse response, String email) throws Exception;



}
