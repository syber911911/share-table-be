package com.loadToFerrai.share_table_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Party {

    @Id @GeneratedValue
    @Column(name = "party_id")
    private Long id;

    // TODO User >- Party -< Post
}
