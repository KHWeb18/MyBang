
package com.mybang.khweb.request;

import com.mybang.khweb.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class MemberDto {
    private String userId;
    private String password;
    private String email;
    private String name;
    private int age;
    private String sex;
    private String phone;

    public Member toEntity() {
        return Member.builder()
                .userId(userId)
                .password(password)
                .email(email)
                .name(name)
                .age(age)
                .sex(sex)
                .phone(phone)
                .build();
    }
}
