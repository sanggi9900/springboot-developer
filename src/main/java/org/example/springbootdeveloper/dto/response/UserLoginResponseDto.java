package org.example.springbootdeveloper.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginResponseDto {
    private  String token; // 로그인을 하면 토큰을 반환

}
