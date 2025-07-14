package com.floop.Ecommerce.signup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserIdCheckResponseDto {
    private boolean isDuplicate;
    private String message;
}
