package com.invesko.ask.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.invesko.ask.model.Answers;

public interface AnswerService {

	Page<Answers> findByProblemId(Pageable pageable,Long problemId);

	void saveAnswer(Answers answer);

}