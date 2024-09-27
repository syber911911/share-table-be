package com.loadToFerrai.share_table_api.dto.authorizationDto;


import com.loadToFerrai.share_table_api.entity.embedded.UserAgentInfo;
import com.loadToFerrai.share_table_api.entity.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDetailBody {

    @Null
    private String userName;

    @Email
    private String userEmailAddress;

    @NotNull @Min(value = 10) @Max(value = 80)
    private String userAgeRange;

    @NotBlank(message = "반드시 입력해주세요")
    private String userProfileNickname;

    private String userProfileIMG;

    @NotNull
    private Gender userGender;

    private UserAgentInfo userAgentInfo;
}
