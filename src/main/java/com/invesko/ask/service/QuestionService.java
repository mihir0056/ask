package com.invesko.ask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.invesko.ask.model.Questions;

public interface QuestionService {

	Optional<Questions> findById(Long id);

	void saveQuestions(Questions user);

	Page<Questions> findAllQuestions(Pageable pageable);
}