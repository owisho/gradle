package com.manning.gia.todo.model;

public class ToDoItem implements Comparable<ToDoItem>{
	
	private Long id;
	private String name;
	private boolean completed;
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public boolean isCompleted(){
		return this.completed;
	}
	
	public void setCompleted(boolean completed){
		this.completed = completed;
	}
	
	@Override
	public int compareTo(ToDoItem item){
		return this.name.compareTo(item.name);
	}
	
	@Override
	public String toString(){
		return "id:"+this.id+";name:"+this.name+";completed:"+this.completed;
	}

}