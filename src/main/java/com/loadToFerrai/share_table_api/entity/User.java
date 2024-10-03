package com.loadToFerrai.share_table_api.entity;

import com.loadToFerrai.share_table_api.entity.embedded.UserAgentInfo;
import com.loadToFerrai.share_table_api.entity.enums.Gender;
import com.loadToFerrai.share_table_api.entity.enums.UserAuthorityType;
import jakarta.persistence.*;
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

    private String userName;
    private String userEmailAddress;
    private String userAgeRange;
    private String userProfileNickname;
    private String userProfileIMG;
    @Enumerated(EnumType.STRING)
    private Gender userGender;
    @Embedded
    private UserAgentInfo userAgentInfo;
    @Enumerated(EnumType.STRING)
    private UserAuthorityType userAuthorityType;

    @Builder
    public User(UserAgentInfo userAgentInfo) {
        this.userAgentInfo = userAgentInfo;
    }

    @Builder
    public User(String userName, String userEmailAddress, String userAgeRange,
                String userProfileNickname, String userProfileIMG,
                Gender userGender, UserAgentInfo userAgentType, UserAuthorityType userAuthorityType) {
        this.userName = userName;
        this.userEmailAddress = userEmailAddress;
        this.userAgeRange = userAgeRange;
        this.userProfileNickname = userProfileNickname;
        this.userProfileIMG = userProfileIMG;
        this.userGender = userGender;
        this.userAgentInfo = userAgentType;
        this.userAuthorityType = userAuthorityType;
    }
}
