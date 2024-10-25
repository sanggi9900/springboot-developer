package org.example.springbootdeveloper.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSignInRequestDto {
    @NotNull // 필수값검증
    private String email;
    @NotNull
    private String password;
}