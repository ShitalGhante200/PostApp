package com.springdto.PostApp.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.springdto.PostApp.Repository.PostRepository;
import com.springdto.PostApp.model.Post;
import com.springdto.PostApp.service.PostService;


@Service
public class PostServiceImpl implements PostService{
	
	
	@Autowired
	private PostRepository postRepository;
	
	

	public PostServiceImpl(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}



	@Override
	public Post createPost(Post post) {
		
		return postRepository.save(post);
	}



	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}



	@Override
	public Post updatePost(Long id, Post postRequest) {
		 Post post = postRepository.findById(id)
	                .orElseThrow(() -> new NoSuchElementException("Post not found with id: " + id));
		
		post.setTitle(postRequest.getTitle());
		post.setDescription(postRequest.getDescription());
		post.setContent(postRequest.getContent());
		return postRepository.save(post);
	}



	@Override
	public void deletePost(Long id) {
		 Post post = postRepository.findById(id)
	                .orElseThrow(() -> new NoSuchElementException("Post not found with id: " + id));
		
		postRepository.delete(post);
	}



	@Override
	public Post getPostById(Long id) {
//		Optional<Post> result = postRepository.findById(id);
//		if(result.isPresent()) {
//			return result.get();
//		}else {
//			throw  new NoSuchElementException("Post not found with id: " + id);
//		}
		
		Post post = postRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Post not found with id: " + id));
		
		return post;
	}
	
	

}
