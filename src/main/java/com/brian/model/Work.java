package com.brian.model;

public class Work implements java.io.Serializable {
	private String todo;

	public Work() {};
	
	public Work(String todo) {
		this.todo = todo;
	}
 	
	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}
	
}
