package com.quiz.Service;

import java.util.List;

import org.springframework.aot.nativex.NativeConfigurationWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.Dao.QuestionDao;
import com.quiz.Dao.QuizDao;
import com.quiz.Entities.Question;
import com.quiz.Entities.Quiz;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title){
		List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);
		 
		Quiz quiz = new Quiz();
		quiz.setQuestions(questions);
		quiz.setTitle(title);
		
		quizDao.save(quiz);
		return new ResponseEntity<> ("Success",HttpStatus.CREATED);
	}
}
