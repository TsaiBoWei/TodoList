package com.brian.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TodoList implements java.io.Serializable {
	private List<Work> list = new ArrayList<Work>();
	private long id;
	private String name;

	public TodoList() {
	};

	public TodoList(long id, String name) {
		this.name = name;
		this.id = id;
	}

	public TodoList(List<Work> todos, String name, long id) {
		this.list = todos;
		this.name = name;
		this.id = id;
	}

	public TodoList AddList(Work work) {
		this.list.add(work);
		return this;
	}

	public TodoList RemoveWork(String work) {
		Work temp = null;
		for (Work tempWork : list) {
			temp = tempWork.getTodo().equals(work) ? tempWork : null;
			if (temp != null)
				break;
		}
		if (temp != null)
			list.remove(temp);
		return this;
	}

	public TodoList UpdateWork(String oldwork, String newwork) {
		Work temp = null;
		for (Work tempWork : list) {
			temp = tempWork.getTodo().equals(oldwork) ? tempWork : null;
			if (temp != null) {
				temp.setTodo(newwork);
				break;
			}
		}

		if (temp == null) {
			list.add(new Work(newwork));
		}
		return this;
	}

	public List<Work> getList() {
		return list;
	}

	public void setList(List<Work> todos) {
		this.list = todos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
