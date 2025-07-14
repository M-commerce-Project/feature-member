package com.floop.Ecommerce.signup.dto;

import com.floop.Ecommerce.signup.entity.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.bridge.IMessage;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
public class SignUpRequestDto {

    @NotBlank(message = "아이디는필수 입력 값입니다.")
    @Size(min =4, max=20,message = "아이디는 4~20자여야 합니다.")
    private String userId;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;


    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
    private String nickname;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Size(min = 8,message = "비밀번호는 8자 이상이어야 합니다")
    private String password;

    public Member toEntity(PasswordEncoder encoder){
        return Member.builder()
                .userId(this.userId)
                .name(this.name)
                .password(encoder.encode(this.password))
                .build();

    }

}
