package com.loadToFerrai.share_table_api.util.JWTDecoder;


import com.loadToFerrai.share_table_api.dto.authorizationDto.Apple.AppleClaimDTO;
import com.loadToFerrai.share_table_api.dto.authorizationDto.Apple.AppleResponseDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AppleJWTUtil {

    @Value("${tokenProcessor.apple.signingKey}")
    private String appleSigningKey;

    public AppleResponseDTO decodeIdToken(String idToken) {

        AppleClaimDTO appleClaim = claimMapper(
                Jwts.parser()
                .setSigningKey(appleSigningKey)
                .parseClaimsJws(idToken)
                .getBody()
        );

        return AppleResponseDTO.builder()
                .id(appleClaim.getId())
                .email(appleClaim.getEmail())
                .givenName(appleClaim.getNameMap().get("given_name"))
                .familyName(appleClaim.getNameMap().get("family_name"))
                .build();
    }

    private AppleClaimDTO claimMapper(Claims claims) {
        return AppleClaimDTO.builder()
                .id(claims.get("id", String.class))
                .email(claims.get("email", String.class))
                .nameMap((Map<String, String>) claims.get("name", Map.class))
                .build();
    }

}
