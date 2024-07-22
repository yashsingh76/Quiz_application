package com.quiz.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.Entities.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

	List<Question> findByCategory(String category);

	@Query(value = "SELECT * FROM question WHERE category= ? ORDER BY RAND() LIMIT ?", nativeQuery = true)
	List<Question> findRandomQuestionByCategory(String category, int numQ);
}
