package com.loadToFerrai.share_table_api.Dto;

import com.loadToFerrai.share_table_api.Entity.Enum.Gender;
import com.loadToFerrai.share_table_api.Entity.Enum.UserAgentType;
import com.loadToFerrai.share_table_api.Entity.Enum.UserAuthorityType;
import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDTO {

    private String userName;
    private String userEmailAddress;
    private String userAgeRange;
    private String userProfileNickname;
    private String userProfileIMG;
//    private String userAgentId;
    private Gender userGender;
    private UserAuthorityType userAuthorityType;
    private UserAgentType userAgentType;

    @Builder
    public UserDTO(String userName, String userEmailAddress, String userAgeRange,
                   String userProfileNickname, String userProfileIMG, /*String userAgentId,*/
                   Gender userGender, UserAuthorityType userAuthorityType, UserAgentType userAgentType) {
        this.userName = userName;
        this.userEmailAddress = userEmailAddress;
        this.userAgeRange = userAgeRange;
        this.userProfileNickname = userProfileNickname;
        this.userProfileIMG = userProfileIMG;
//        this.userAgentId = userAgentId;
        this.userGender = userGender;
        this.userAuthorityType = userAuthorityType;
        this.userAgentType = userAgentType;
    }
}
