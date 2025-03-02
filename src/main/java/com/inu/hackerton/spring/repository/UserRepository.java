package com.inu.hackerton.spring.repository;

import com.inu.hackerton.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 추가적인 쿼리 메소드가 필요하면 여기 추가
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
