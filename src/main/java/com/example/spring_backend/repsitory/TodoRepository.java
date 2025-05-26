package com.example.spring_backend.repsitory;

import com.example.spring_backend.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("SELECT t FROM Todo t WHERE t.user_id = :userId")
    List<Todo> getByUserId(@Param("userId") Long userId);
	
}