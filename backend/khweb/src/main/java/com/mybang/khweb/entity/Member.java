package com.mybang.khweb.entity;

import com.mybang.khweb.request.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




@Builder

@Entity
//@Data
@NoArgsConstructor
@AllArgsConstructor



public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;




    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private String phone;

    public void modifyMember(MemberDto memberDto) {
        this.password = memberDto.getPassword();
        this.email = memberDto.getEmail();
        this.phone = memberDto.getPhone();
    }
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<MemberAuth> authList = new ArrayList<MemberAuth>();

    public Member(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public void addAuth(MemberAuth auth) {
        authList.add(auth);
    }

    public void clearAuthList () {
        authList.clear();
    }



}

