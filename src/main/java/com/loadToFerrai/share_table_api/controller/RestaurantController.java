package com.loadToFerrai.share_table_api.controller;

import com.loadToFerrai.share_table_api.dto.ResponseDto;
import com.loadToFerrai.share_table_api.dto.restaurant.RestaurantDto;
import com.loadToFerrai.share_table_api.dto.restaurant.RestaurantInfoBody;
import com.loadToFerrai.share_table_api.dto.restaurant.RestaurantSearchCondition;
import com.loadToFerrai.share_table_api.service.restaurant.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.loadToFerrai.share_table_api.controller.controllerUtil.HeadersUtil.getHeaders;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apiRestaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;


    @GetMapping("/info/{id}")
    public ResponseEntity<ResponseDto> getRestaurantsInfoDetail(@PathVariable("id") Long id) {
        RestaurantDto result = restaurantService.findPKRestaurantDTO(id);

        return ResponseEntity.ok()
                .headers(getHeaders())
                .body(new ResponseDto<RestaurantDto>(true, result));
    }

    @GetMapping("/info")
    public ResponseEntity<ResponseDto> getRestaurantsInfoPageable(@RequestBody RestaurantSearchCondition condition, Pageable pageable) {
        Page<RestaurantDto> result = restaurantService.findRestaurantByFilter(condition, pageable);

        return ResponseEntity.ok()
                .headers(getHeaders())
                .body(new ResponseDto<>(true, result.getContent()));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerRestaurant(@RequestBody RestaurantInfoBody body) {
        boolean isExist = restaurantService.existRestaurantInfo(body.getName(), body.getAddress());

        if (isExist) {
            return ResponseEntity.badRequest()
                    .headers(getHeaders())
                    .body(new ResponseDto<String>(false, "이미 존재하는 식당입니다."));
        }

        RestaurantDto restaurantDto = restaurantService.registerRestaurant(body);
        return ResponseEntity.ok()
                .headers(getHeaders())
                .body(new ResponseDto<RestaurantDto>(true, restaurantDto));
    }



}
