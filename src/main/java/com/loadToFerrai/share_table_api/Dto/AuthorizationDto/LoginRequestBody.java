package com.loadToFerrai.share_table_api.Dto.AuthorizationDto;



import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequestBody {
    private String agentUserId;
    private String accessToken;
}
