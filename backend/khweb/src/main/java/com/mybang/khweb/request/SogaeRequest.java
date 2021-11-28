package com.mybang.khweb.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SogaeRequest {
    private Long sogaeNo;
    private String title;
    private String writer;
    private String description;


    public SogaeRequest(Long sogaeNo,String title, String writer, String description) {
        this.sogaeNo = sogaeNo;
        this.title = title;
        this.writer = writer;
        this.description = description;
    }

}
