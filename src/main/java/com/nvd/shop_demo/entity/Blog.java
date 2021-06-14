package com.nvd.shop_demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Blog extends BaseEntity {
    @Column
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Column
    private String title;

    @Column(columnDefinition = "longtext")
    private String content;

    @Column
    private String keyword;

    @Column
    private String thumbnail;

    @Column
    private String albums;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
