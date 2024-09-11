package com.loadToFerrai.share_table_api.Dto;

import com.loadToFerrai.share_table_api.Entity.Embedded.UserAgentInfo;
import com.loadToFerrai.share_table_api.Entity.Enum.Gender;
import com.loadToFerrai.share_table_api.Entity.Enum.UserAuthorityType;
import lombok.*;

@Getter @Setter
public class UserDTO {

    private String userName;
    private String userEmailAddress;
    private String userAgeRange;
    private String userProfileNickname;
    private String userProfileIMG;
    private Gender userGender;
    private UserAgentInfo userAgentInfo;
    private UserAuthorityType userAuthorityType;

    public UserDTO() {}

    @Builder
    public UserDTO(String userName, String userEmailAddress, String userAgeRange,
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
