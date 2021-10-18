
package com.mybang.khweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "member_auth")
public class MemberAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberAuthNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 64, nullable = false)
    private String auth;
}
