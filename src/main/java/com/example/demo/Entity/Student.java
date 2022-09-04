package com.example.demo.Entity;


 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "students")
public class Student 
{ 


	@Id
	@Column(name="id")
	private Integer id;
	 public Integer getId() {
		return id;
	}
	public void setId(Integer string) {
		this.id = string;
	}
	
	
	@Column(name="Description")
	String Description;
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Column(name="Target_date")
	 String Target_date;
	public String getTarget_date() {
		return Target_date;
	}
	public void setTarget_date(String target_date) {
		Target_date = target_date;
	}
	@Column(name="Isdone")
	 String Isdone;
	public String getisdone() {
		return Isdone;
	}
	public void setisdone(String isdone) {
		this.Isdone = isdone;
	}

}
