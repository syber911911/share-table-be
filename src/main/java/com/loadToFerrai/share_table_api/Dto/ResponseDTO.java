package com.loadToFerrai.share_table_api.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {

    private Boolean success;
    private T result;
}
