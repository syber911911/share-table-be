package com.loadToFerrai.share_table_api.Entity;

import com.loadToFerrai.share_table_api.Entity.Embedded.UserAgentInfo;
import com.loadToFerrai.share_table_api.Entity.Enum.Gender;
import com.loadToFerrai.share_table_api.Entity.Enum.UserAuthorityType;
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
    private Gender userGender;
    @Embedded
    private UserAgentInfo userAgentInfo;
    private UserAuthorityType userAuthorityType;

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
