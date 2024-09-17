package com.loadToFerrai.share_table_api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {

    private Boolean success;
    private T result;
}
