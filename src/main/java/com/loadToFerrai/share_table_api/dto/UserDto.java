package com.loadToFerrai.share_table_api.dto;

import com.loadToFerrai.share_table_api.entity.embedded.UserAgentInfo;
import com.loadToFerrai.share_table_api.entity.enums.Gender;
import com.loadToFerrai.share_table_api.entity.enums.UserAuthorityType;
import lombok.*;

@Getter @Setter
public class UserDto {

    private String userName;
    private String userEmailAddress;
    private String userAgeRange;
    private String userProfileNickname;
    private String userProfileIMG;
    private Gender userGender;
    private UserAgentInfo userAgentInfo;
    private UserAuthorityType userAuthorityType;

    public UserDto() {}

    @Builder
    public UserDto(String userName, String userEmailAddress, String userAgeRange,
                   String userProfileNickname, String userProfileIMG,
                   Gender userGender, UserAgentInfo userAgentInfo, UserAuthorityType userAuthorityType) {
        this.userName = userName;
        this.userEmailAddress = userEmailAddress;
        this.userAgeRange = userAgeRange;
        this.userProfileNickname = userProfileNickname;
        this.userProfileIMG = userProfileIMG;
        this.userGender = userGender;
        this.userAgentInfo = userAgentInfo;
        this.userAuthorityType = userAuthorityType;
    }
}
