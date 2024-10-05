package com.loadToFerrai.share_table_api.dto.authorizationDto;


import com.loadToFerrai.share_table_api.entity.embedded.UserAgentInfo;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserInfoBody {
    @Embedded @NotNull
    private UserAgentInfo userAgentInfo;
}
