package com.chobo.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //로그인한 사람이 이미 가입된 회원인지 아닌지 판별
    Optional<User> findByEmail(String email);
}

