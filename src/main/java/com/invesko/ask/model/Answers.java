package com.invesko.ask.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="ANSWERS")
public class Answers implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="PROBLEM_ID", nullable=false)
	private long problemId;

	@Column(name="ANSWER", nullable=false)
	private String answer;

	@Column(name="CREATION_DT")
	private Date creationDt;
	
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "PROBLEM_ID" , insertable = false, updatable = false)
	 * private Questions question;
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getProblemId() {
		return problemId;
	}

	public void setProblemId(long problemId) {
		this.problemId = problemId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getCreationDt() {
		return creationDt;
	}

	public void setCreationDt(Date creationDt) {
		Date date = new Date();
		this.creationDt = date;
	}

	/*
	 * public Questions getQuestion() { return question; }
	 * 
	 * public void setQuestion(Questions question) { this.question = question; }
	 */

	
	
}
