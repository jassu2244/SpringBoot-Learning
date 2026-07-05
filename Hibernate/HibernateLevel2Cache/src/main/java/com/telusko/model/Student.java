package com.telusko.model;


import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="StudentTable")
@Cacheable //this comes from persistence package, To activate level 2 caching we need to add these 2 annotation in entity class
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY) //this comes from hibernate
public class Student {
	
	@Id //this annotation tells us that make this column primary key
	@Column(name="SID")
     private Integer sid;
     
	@Column(name="SNAME")
     private String sName;
     
	@Column(name="SCITY")
     private String scity;
	
	public Student()
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
		return "Student [sid=" + sid + ", sName=" + sName + ", scity=" + scity + "]";
	}
}
