package com.invesko.ask.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.invesko.ask.model.Answers;
import com.invesko.ask.model.Questions;
import com.invesko.ask.service.AnswerService;
import com.invesko.ask.service.QuestionService;

@RestController
@RequestMapping("/ask/api")
@CrossOrigin(origins="*")
public class AskApiController {

	public static final Logger logger = LoggerFactory.getLogger(AskApiController.class);

	@Autowired
	QuestionService questionService;

	@Autowired
	AnswerService answerService;

	@RequestMapping(value = "/questions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity getAllProblems(@PageableDefault(value = 10, page = 0) Pageable pageable) {

		System.out.println("==== get questions");

		return new ResponseEntity(questionService.findAllQuestions(pageable), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/questions/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity getQuestion(@PathVariable("id") long id) {

		System.out.println("==== get ansewers for problem id : " + id);

		return new ResponseEntity(questionService.findById(id), HttpStatus.OK);

	}

	@RequestMapping(value = "/questions/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addQuestion(@RequestBody Questions question) {

		System.out.println("==== add question");

		if (question != null) {
			Date dt = new Date();
			question.setCreationDt(dt);
			questionService.saveQuestions(question);
			return new ResponseEntity<String>(question.toString(), HttpStatus.CREATED);
		} else {
			System.out.println("NO CONTENT");
			return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/answers/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addAnswer(@RequestBody Answers answer) {

		System.out.println("==== add answer");

		if (answer != null) {
			Date dt = new Date();
			answer.setCreationDt(dt);
			answerService.saveAnswer(answer);
			return new ResponseEntity<String>(answer.toString(), HttpStatus.CREATED);
		} else {
			System.out.println("NO CONTENT");
			return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/answers/{problemId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity getAnswers(@PageableDefault(value = 10, page = 0) Pageable pageable,
			@PathVariable("problemId") long problemId) {

		System.out.println("==== get ansewers for problem id : " + problemId);

		return new ResponseEntity(answerService.findByProblemId(pageable, problemId), HttpStatus.OK);

	}

}