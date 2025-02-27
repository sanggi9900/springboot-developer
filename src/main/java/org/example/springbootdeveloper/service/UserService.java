package org.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    // 비즈니스 로직
    // Controller의 요청을 받아 필요한 데이터를 Repository를 통해 얻거나 전달하고
    // , 기능 구현 후 응답을 Controller에게 전달
    // +) 기능 구현에 있어 필요한 보안을 설정

    private final UserRepository userRepository;
    }



