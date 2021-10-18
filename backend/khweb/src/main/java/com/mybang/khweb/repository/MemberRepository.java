package com.mybang.khweb.repository;

import com.mybang.khweb.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m join fetch m.authList where m.memberNo = :memberNo")
    Optional<Member> findByAuth(Long memberNo);


}
