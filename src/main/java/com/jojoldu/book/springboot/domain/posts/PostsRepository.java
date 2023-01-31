package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {    //<클래스,PK타입>
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")  //SpringDataJpa에서 제공안하면 쿼리로 작성해도됨
    List<Posts> findAllDesc();
}
