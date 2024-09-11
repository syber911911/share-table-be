package com.loadToFerrai.share_table_api.WebClient;

import com.loadToFerrai.share_table_api.Dto.AuthorizationDto.Kakao.KakaoResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientUtil {

    @Value("${accessTokenRequestApi.kakao}")
    private String kakaoRequestApi;

    public static KakaoResponseDTO getKakaoUserInfo(String accessToken) {
        WebClient kakoAuthorization = WebClient.builder()
                .baseUrl("")
                .defaultHeader("Authorization", accessToken)
                .defaultHeader("content-type", "application/x-www-form-urlencoded;charset=UTF-8")
                .build();

        return kakoAuthorization
                .get()
                .retrieve()
                .bodyToMono(KakaoResponseDTO.class)
                .block();

    }
}
