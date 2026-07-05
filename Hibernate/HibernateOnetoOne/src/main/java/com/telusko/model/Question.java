package com.telusko.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Question 
{
	 @Id
	 @Column(name="question_id") // this annotation is used to give column name of my own choice
     private Integer id;
	 
     private String question; 
     
     
     //this is linking both the table so whatever happens to one happens to other too based on id(primary key)
     @OneToOne(cascade=CascadeType.ALL) //this annotation is used to achieve relationship between quesiton and answer
     private Answer answer; // this is reference variable for Answer object
     
     public Question()
     {
    	 System.out.println("Zero Param Constructor of Question");
     }

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
}
