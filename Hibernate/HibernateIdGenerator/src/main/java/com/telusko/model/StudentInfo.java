package com.telusko.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentInfo")
public class StudentInfo 
{ 
	//here we need id to generate automatically so we use autoincrement that we can do using GeneratedValue annotation
	@Id
	@GeneratedValue(generator="my_seq" ,strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name="my_seq",sequenceName="My_OwnSequence", initialValue=100, allocationSize=1) // this is used to give my own sequence
     private Integer sid;
     
     private String sName;
     
     private String scity;
	
	public StudentInfo()
	{
		System.out.println("Zero Param Constructor for Hibernate");
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getScity() {
		return scity;
	}

	public void setScity(String scity) {
		this.scity = scity;
	}

	@Override
	public String toString() {
		return "StudentInfo [sid=" + sid + ", sName=" + sName + ", scity=" + scity + "]";
	}
}
