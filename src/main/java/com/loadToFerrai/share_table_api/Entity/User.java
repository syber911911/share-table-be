package com.loadToFerrai.share_table_api.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String emailAddress;
    private String phoneNumber;
    private String gender; // todo Enum으로 변경
    private Integer age;

    @Builder
    public User(String emailAddress, String phoneNumber, String gender, Integer age) {
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }
}
