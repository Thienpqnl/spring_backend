package com.example.spring_backend;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.*;

import jakarta.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private boolean completed;
	private String time;
    public Todo() {
    }

	
	public Todo(String title, String description, boolean completed, String time) {
		super();
		this.title = title;
		this.description = description;
		this.completed = completed;
		this.time = time;
	}

	public Todo(Long id, String title, boolean completed, String time) {
		super();
		this.id = id;
		this.title = title;
		this.completed = completed;
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}

	// getter + setter + constructor

}
