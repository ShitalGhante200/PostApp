package com.springdto.PostApp.Dto;

import lombok.Data;

@Data
public class PostDto {
	
	private Long id;
	private String title;
	private String description;
	private String content;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	public PostDto(Long id, String title, String description, String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
	}
	
	
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "PostDto [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content + "]";
	}
	
}
