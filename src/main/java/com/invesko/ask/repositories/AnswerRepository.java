package com.invesko.ask.repositories;

import com.invesko.ask.model.Answers;
import com.invesko.ask.model.Questions;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answers, Long> {
	
	Page<Answers> findByProblemIdOrderByCreationDtDesc(Pageable pageable, long id);

}
