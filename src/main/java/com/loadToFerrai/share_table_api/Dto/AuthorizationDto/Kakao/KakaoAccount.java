package com.loadToFerrai.share_table_api.Dto.AuthorizationDto.Kakao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class KakaoAccount {
    private Boolean profile_needs_agreement;
    private Boolean profile_nickname_needs_agreement;
    private Boolean profile_image_needs_agreement;
    private Profile profile;

    private Boolean name_needs_agreement;
    private String name;

    private Boolean email_needs_agreement;
    private Boolean is_email_valid;
    private Boolean is_email_verified;
    private String email;

    private Boolean age_range_needs_agreement;
    private String age_range;

    private Boolean birthyear_needs_agreement;
    private String birthyear;
    private String birthday;
    private String birthday_type;

    private Boolean gender_needs_agreement;
    private String gender;

    private Boolean phone_number_needs_agreement;
    private String phone_number;

    private Boolean ci_needs_agreement;
    private String ci;
    private LocalDateTime ci_authenticated_at;

}
