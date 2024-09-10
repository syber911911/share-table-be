package com.loadToFerrai.share_table_api.Dto.AuthorizationDto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequestBody {
    private String agentUserId;
    private String accessToken;
}
