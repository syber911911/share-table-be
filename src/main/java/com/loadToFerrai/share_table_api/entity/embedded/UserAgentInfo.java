package com.loadToFerrai.share_table_api.entity.embedded;

import com.loadToFerrai.share_table_api.entity.enums.UserAgentType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAgentInfo {

    private String userAgentId;

    @Enumerated(EnumType.STRING)
    private UserAgentType userAgentType;

    @Builder
    public UserAgentInfo(String userAgentId, UserAgentType userAgentType) {
        this.userAgentId = userAgentId;
        this.userAgentType = userAgentType;
    }
}
