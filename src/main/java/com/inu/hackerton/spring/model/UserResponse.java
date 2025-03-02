package com.inu.hackerton.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    private Long id;        // 사용자 ID
    private String username; // 사용자 이름
    private String email;    // 사용자 이메일
}
