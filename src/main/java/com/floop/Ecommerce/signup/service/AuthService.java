package com.floop.Ecommerce.signup.service;

import com.floop.Ecommerce.signup.dto.SignUpRequestDto;

public interface AuthService {
    void signup(SignUpRequestDto requestDto);

}
