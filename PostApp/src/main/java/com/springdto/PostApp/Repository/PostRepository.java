package com.springdto.PostApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdto.PostApp.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
