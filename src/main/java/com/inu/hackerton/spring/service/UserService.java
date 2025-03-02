package com.inu.hackerton.spring.service;

import com.inu.hackerton.spring.model.User;
import com.inu.hackerton.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public Optional<User> read(Long id) {
        return userRepository.findById(id);
    }

    public User update(Long id, User updatedUser) {
        // id가 존재하는지 확인하고 없으면 예외 처리
        if (id == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id 0 not found");
        }

        // 유저가 존재하지 않으면 예외 처리
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        // 유저 정보 업데이트
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());

        // 수정된 유저를 저장
        return userRepository.save(user);
    }

}
