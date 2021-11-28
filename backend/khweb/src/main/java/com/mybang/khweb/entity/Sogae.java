package com.mybang.khweb.entity;


import com.mybang.khweb.request.GongziRequest;
import com.mybang.khweb.request.SogaeRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="sogae")
public class Sogae extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sogae_no", nullable = false)
    private Long sogaeNo;

    @Column(length = 40, nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(length = 1000, nullable = false)
    private String description;


    public Sogae(String title, String writer, String description) {

        this.title = title;
        this.writer = writer;
        this.description = description;

    }
    public void updateSogae(SogaeRequest request) {
        this.title = request.getTitle();
        this.description = request.getDescription();

    }


}
