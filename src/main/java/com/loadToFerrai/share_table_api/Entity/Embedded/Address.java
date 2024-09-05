package com.loadToFerrai.share_table_api.Entity.Embedded;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {


    private String doName;
    private String siName;
    private String roadName;
    private String detail;
    private String postalCode;

    @Builder
    public Address(String doName, String siName, String roadName, String detail, String postalCode) {
        this.doName = doName;
        this.siName = siName;
        this.roadName = roadName;
        this.detail = detail;
        this.postalCode = postalCode;
    }
}
