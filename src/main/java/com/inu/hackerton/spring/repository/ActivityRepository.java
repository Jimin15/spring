package com.inu.hackerton.spring.repository;

import com.inu.hackerton.spring.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    // 추가적인 쿼리 메서드를 작성할 수 있습니다.
}
