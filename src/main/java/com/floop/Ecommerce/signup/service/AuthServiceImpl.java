package com.floop.Ecommerce.signup.service;


import com.floop.Ecommerce.signup.dto.SignUpRequestDto;
import com.floop.Ecommerce.signup.entity.Member;
import com.floop.Ecommerce.signup.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signup(SignUpRequestDto requestDto) {
        // 아이디 중복 체크
        if (memberRepository.existsByUserId(requestDto.getUserId())) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }

        // 비밀번호 암호화
        Member member = requestDto.toEntity(passwordEncoder);

        // DB 저장
        memberRepository.save(member);
    }
}
