package com.springdto.PostApp.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.event.internal.PostDeleteEventListenerStandardImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdto.PostApp.Dto.PostDto;
import com.springdto.PostApp.model.Post;
import com.springdto.PostApp.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	private PostService postService;

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	@GetMapping("/{id}")
	public List<PostDto> getAllPosts(){
		return postService.getAllPosts().stream().map(post -> modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
	}
	
	@PostMapping
	public ResponseEntity<PostDto> createPost( @RequestBody PostDto postDto){
		
		
		// convert DTO to entity
		Post postRequest =	modelMapper.map(postDto, Post.class);
		Post post = 	postService.createPost(postRequest);
		
		// convert entity to DTO
		PostDto postResponse = modelMapper.map(post, PostDto.class);
		return new ResponseEntity<PostDto>(postResponse, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@PathVariable long id, @RequestBody PostDto postDto) {

		// convert DTO to Entity
		Post postRequest = modelMapper.map(postDto, Post.class);

		Post post = postService.updatePost(id, postRequest);

		// entity to DTO
		PostDto postResponse = modelMapper.map(post, PostDto.class);

		return ResponseEntity.ok().body(postResponse);
	}
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<ApiResponse> deletePost(@PathVariable(name = "id") Long id) {
//		postService.deletePost(id);
//		ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Post deleted successfully", HttpStatus.OK);
//		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
//	}
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Map<String, Object>> deletePost(@PathVariable(name = "id") Long id) {
	        postService.deletePost(id);

	        Map<String, Object> response = new HashMap<>();
	        response.put("success", true);
	        response.put("message", "Post deleted successfully");
	        response.put("status", HttpStatus.OK);

	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

}  
