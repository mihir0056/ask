package com.invesko.ask.repositories;

import com.invesko.ask.model.Questions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Long> {

	Page<Questions> findByOrderByCreationDtDesc(Pageable pageable);

}
