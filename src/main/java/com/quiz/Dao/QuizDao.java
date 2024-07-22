package com.quiz.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.Entities.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
