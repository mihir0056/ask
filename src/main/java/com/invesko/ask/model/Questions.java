package com.invesko.ask.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="QUESTIONS")
public class Questions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="TITLE", nullable=false)
	private String title;
	
	@Column(name="QS_DES", nullable=false)
	private String qsdes;

	@Column(name="CREATION_DT")
	private Date creationDt;
	
	@OneToMany
	@JoinColumn(name = "PROBLEM_ID" , insertable = false, updatable = false)
	@OrderBy("creationDt desc")
	private List<Answers> answer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQsdes() {
		return qsdes;
	}

	public void setQsdes(String qsdes) {
		this.qsdes = qsdes;
	}

	public Date getCreationDt() {
		return creationDt;
	}

	public void setCreationDt(Date creationDt) {
		Date date = new Date();
		this.creationDt = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Answers> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answers> answer) {
		this.answer = answer;
	}

	
}
