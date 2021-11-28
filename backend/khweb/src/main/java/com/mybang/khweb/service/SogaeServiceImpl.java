package com.mybang.khweb.service;

import com.mybang.khweb.entity.Sogae;
import com.mybang.khweb.repository.SogaeRepository;
import com.mybang.khweb.request.SogaeRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class SogaeServiceImpl implements SogaeService{
    @Autowired
    private SogaeRepository sogaeRepository;


    @Override
    public void upload(SogaeRequest sogaeRequest) throws Exception {

        Sogae sogae = new Sogae(sogaeRequest.getTitle(),sogaeRequest.getWriter(), sogaeRequest.getDescription());


        sogaeRepository.save(sogae);
    }

    @Override
    public List<Sogae> list() throws Exception {
        return sogaeRepository.getList();
    }

    @Override
    public Sogae read(Integer sogaeNo) throws Exception {
        return sogaeRepository.getRead(new Long(sogaeNo));
    }

    @Override
    public void delete(Integer sogaeNo) throws Exception {
        sogaeRepository.delete(new Long(sogaeNo));
    }

    @Override
    public void modify(SogaeRequest sogaeRequest) throws Exception {

        String title = sogaeRequest.getTitle();
        String description = sogaeRequest.getDescription();
        Long sogaeNo = new Long(sogaeRequest.getSogaeNo());

        sogaeRepository.modify(title, description,sogaeNo);
    }
}
