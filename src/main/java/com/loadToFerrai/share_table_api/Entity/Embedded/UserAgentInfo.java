package com.loadToFerrai.share_table_api.Entity.Embedded;

import com.loadToFerrai.share_table_api.Entity.Enum.UserAgentType;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAgentInfo {

    private String userAgentId;
    private UserAgentType userAgentType;

    @Builder
    public UserAgentInfo(String userAgentId, UserAgentType userAgentType) {
        this.userAgentId = userAgentId;
        this.userAgentType = userAgentType;
    }
}
