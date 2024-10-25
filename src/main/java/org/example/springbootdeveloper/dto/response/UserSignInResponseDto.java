package org.example.springbootdeveloper.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.springbootdeveloper.entity.User;

@Data
@AllArgsConstructor
public class UserSignInResponseDto {
    private String token; // 로그인을 하면 토큰을 반환
    private User user;

}
