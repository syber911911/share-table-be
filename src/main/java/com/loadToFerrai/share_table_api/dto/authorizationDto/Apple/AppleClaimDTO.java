package com.loadToFerrai.share_table_api.dto.authorizationDto.Apple;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class AppleClaimDTO {
    private String id;
    private String email;
    private Map<String, String> nameMap;

    @Builder
    public AppleClaimDTO(String id, String email, Map<String, String> nameMap) {
        this.id = id;
        this.email = email;
        this.nameMap = nameMap;
    }
}
