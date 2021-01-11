package com.chobo.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;


//Posts 클래스로 Database를 접근하게 해주기 위한 JpaRepository 생성
//JpaRepository를 상속하면 기본적인 CRUD 메소드가 자동적으로 생성됌
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
