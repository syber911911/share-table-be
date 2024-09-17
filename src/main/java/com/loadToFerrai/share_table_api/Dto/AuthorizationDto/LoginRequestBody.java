package com.loadToFerrai.share_table_api.Dto.AuthorizationDto;



import com.loadToFerrai.share_table_api.Entity.Enum.UserAgentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestBody {
    private String agentUserId;
    private String token;
    private UserAgentType agentType;
}
