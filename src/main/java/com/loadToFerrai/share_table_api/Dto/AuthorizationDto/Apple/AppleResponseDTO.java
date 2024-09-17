package com.loadToFerrai.share_table_api.Dto.AuthorizationDto.Apple;

import lombok.*;

@Getter @Setter
public class AppleResponseDTO {
    private String id;
    private String email;
    private String givenName;
    private String familyName;

    @Builder
    public AppleResponseDTO(String id, String email, String givenName, String familyName) {
        this.id = id;
        this.email = email;
        this.givenName = givenName;
        this.familyName = familyName;
    }
}
