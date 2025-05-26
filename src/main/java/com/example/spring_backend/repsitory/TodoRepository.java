package com.example.spring_backend.repsitory;

import com.example.spring_backend.model.Todo;
import com.example.spring_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("SELECT t FROM Todo t JOIN User u ON t.user_id = u.id WHERE u.username = :username")
    List<Todo> getByUsername(@Param("username") String username);

}
