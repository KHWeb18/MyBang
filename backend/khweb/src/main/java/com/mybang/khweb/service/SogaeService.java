package com.mybang.khweb.service;

import com.mybang.khweb.entity.Sogae;
import com.mybang.khweb.request.SogaeRequest;

import java.util.List;

public interface SogaeService {
    public void upload(SogaeRequest sogaeRequest) throws Exception;

    public List<Sogae> list() throws Exception;

    public Sogae read(Integer sogaeNo) throws Exception;

    public void delete(Integer sogaeNo) throws Exception;

    public void modify(SogaeRequest sogaeRequest) throws Exception;
}
