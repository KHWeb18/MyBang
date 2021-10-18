
package com.mybang.khweb.repository;


import com.mybang.khweb.entity.Member;
import com.mybang.khweb.entity.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;


public interface MemberAuthRepository extends JpaRepository<MemberAuth, Long> {

    @Query("select auth from MemberAuth ma where ma.memberNo = :memberNo")
    Optional<MemberAuth> findByMemberNo(Long memberNo);
}





