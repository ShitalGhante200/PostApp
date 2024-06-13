package com.springdto.PostApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springdto.PostApp.model.Post;


@Service
public interface PostService {
	
    List<Post> getAllPosts();
	
	Post createPost(Post post);
	
	Post updatePost(Long id, Post post);
	
	void deletePost(Long id);
	
	Post getPostById(Long id);
	
	

}
