package com.floop.Ecommerce.signup.controller;


import com.floop.Ecommerce.signup.dto.SignUpRequestDto;
import com.floop.Ecommerce.signup.dto.UserIdCheckResponseDto;
import com.floop.Ecommerce.signup.repository.MemberRepository;
import com.floop.Ecommerce.signup.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;
    private final MemberRepository memberRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Valid SignUpRequestDto signUpRequestDto) {
        authService.signup(signUpRequestDto);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }

    @GetMapping("/check-user-id")
    public ResponseEntity<UserIdCheckResponseDto> checkUserIdDuplicate(@RequestParam String userId) {
        boolean isDuplicate = memberRepository.existsByUserId(userId);
        String message = isDuplicate ? "이미 사용중인 아이디입니다." : "사용 가능한 아이디입니다.";
        return ResponseEntity.ok(new UserIdCheckResponseDto(isDuplicate,message));
    }
}
