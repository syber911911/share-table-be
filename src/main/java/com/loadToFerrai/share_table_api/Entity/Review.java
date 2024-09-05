package com.loadToFerrai.share_table_api.Entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id @Getter
    @Column(name = "review_id")
    private Long id;
    private String title;
    private String content;
    private String imgUrl;
    private String reviewPassword;
    private Integer ratings;

    private Timestamp createdAt;
    private Timestamp deletedAt;
    private Timestamp modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    //todo constructor + builder
}
