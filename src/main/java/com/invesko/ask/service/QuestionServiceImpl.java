package com.invesko.ask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invesko.ask.model.Questions;
import com.invesko.ask.repositories.QuestionRepository;
import com.invesko.ask.service.QuestionService;

@Service("questionService")
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Optional<Questions> findById(Long id) {
		// TODO Auto-generated method stub
		return questionRepository.findById(id);
		
	}

	@Override
	public void saveQuestions(Questions question) {
		// TODO Auto-generated method stub
		questionRepository.saveAndFlush(question);
	}

	@Override
	public Page<Questions> findAllQuestions(Pageable pageable) {
		// TODO Auto-generated method stub
		//return questionRepository.findAll(pageable);
		return questionRepository.findByOrderByCreationDtDesc(pageable);

	}

}
