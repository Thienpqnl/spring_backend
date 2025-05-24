package com.example.spring_backend;

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

    public Todo() {
    }

	
	public Todo(String title, String description, boolean completed) {
		super();
		this.title = title;
		this.description = description;
		this.completed = completed;
	}

	public Todo(Long id, String title, boolean completed) {
		super();
		this.id = id;
		this.title = title;
		this.completed = completed;
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

	// getter + setter + constructor

}
