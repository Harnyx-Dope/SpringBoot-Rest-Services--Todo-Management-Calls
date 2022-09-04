package com.example.demo.Response;

public class StudentResponse {
	private Integer id;
	 String Description;
	 String Target_date;
	 String isDone;
	 
		  
		public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getTarget_date() {
		return Target_date;
	}
	public void setTarget_date(String target_date) {
		Target_date = target_date;
	}
	public String getisDone() {
		return isDone;
	}
	public void setDate(String isdone) {
		isDone = isdone;
	}
	 
	private  String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
		
		 
}