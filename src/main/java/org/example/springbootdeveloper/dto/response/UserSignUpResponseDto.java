package org.example.springbootdeveloper.dto.response;

import io.jsonwebtoken.Claims;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springbootdeveloper.entity.User;

@Data
@NoArgsConstructor
public class UserSignUpResponseDto {
    private User user;

    public UserSignUpResponseDto(User user){
        this.user= user;
    }
}
