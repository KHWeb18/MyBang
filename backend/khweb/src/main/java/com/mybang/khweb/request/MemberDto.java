package com.mybang.khweb.request;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private String email;
    private String userName;
    private String password;
    private String passwordConfirm;
    private String auth;
}
