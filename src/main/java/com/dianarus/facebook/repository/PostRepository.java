package com.dianarus.facebook.repository;

import com.dianarus.facebook.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findPostById(int id);
}
