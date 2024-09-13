package com.loadToFerrai.share_table_api.WebClient;

import com.loadToFerrai.share_table_api.Dto.AuthorizationDto.Apple.AppleResponseDTO;
import com.loadToFerrai.share_table_api.Dto.AuthorizationDto.Kakao.KakaoResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientUtil {

    @Value("${accessTokenRequestApi.kakao}")
    private String kakaoRequestApi;

    @Value("${accessTokenRequestApi.apple}")
    private String appleRequestApi;

    public KakaoResponseDTO getKakaoUserInfo(String accessToken) {
        WebClient kakoAuthorization = WebClient.builder()
                .baseUrl(kakaoRequestApi)
                .defaultHeader("Authorization", accessToken)
                .defaultHeader("content-type", "application/x-www-form-urlencoded;charset=UTF-8")
                .build();

        return kakoAuthorization
                .get()
                .retrieve()
                .bodyToMono(KakaoResponseDTO.class)
                .block();
    }

    public AppleResponseDTO getAppleUserInfo(String accessToken) {
        WebClient appleAuthorization = WebClient.builder()
                .baseUrl(appleRequestApi)
                .defaultHeader("")
                .defaultHeader("")
                .build();
        return appleAuthorization
                .get()
                .retrieve()
                .bodyToMono(AppleResponseDTO.class)
                .block();
    }
}
