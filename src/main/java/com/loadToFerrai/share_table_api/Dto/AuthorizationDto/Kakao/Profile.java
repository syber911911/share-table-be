package com.loadToFerrai.share_table_api.Dto.AuthorizationDto.Kakao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class Profile {

    private String nickname;
    private String thumbnail_image_url;
    private String profile_image_url;
    private Boolean is_default_image;
    private Boolean is_default_nickname;
}
