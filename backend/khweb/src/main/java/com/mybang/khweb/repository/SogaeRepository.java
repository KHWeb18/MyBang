package com.mybang.khweb.repository;

import com.mybang.khweb.entity.Gongzi;
import com.mybang.khweb.entity.Officetel;
import com.mybang.khweb.entity.Product;
import com.mybang.khweb.entity.Sogae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface SogaeRepository extends JpaRepository<Sogae, Long> {

    @Query("select m from Sogae m where m.sogaeNo > 0 order by sogaeNo asc")
    List<Sogae> getList();

    @Query("select m from Sogae m where m.sogaeNo = :sogaeNo")
    Sogae getRead(Long sogaeNo);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from Sogae m where m.sogaeNo = :sogaeNo")
    void delete(Long sogaeNo);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Sogae m set m.title = :title, m.description = :description where m.sogaeNo = :sogaeNo")
    void modify(String title, String description,Long sogaeNo);
}
