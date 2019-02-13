package com.invesko.ask.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invesko.ask.model.Answers;
import com.invesko.ask.repositories.AnswerRepository;


@Service("anserService")
@Transactional
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public Page<Answers> findByProblemId(Pageable pageable,Long problemId) {
		// TODO Auto-generated method stub
		return answerRepository.findByProblemIdOrderByCreationDtDesc(pageable,problemId);
		
	}

	@Override
	public void saveAnswer(Answers answer) {
		// TODO Auto-generated method stub
		answerRepository.saveAndFlush(answer);
	}

	

	

}
