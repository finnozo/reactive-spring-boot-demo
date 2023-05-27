package com.sushildangi.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class APIResponse {
    private Long id;
    private String message;
    private Integer statusCode;
    private String statusName;
    private boolean success;
}
