package com.brian.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brian.model.TodoList;
import com.brian.model.Work;

@RestController
public class TodoListController {

	private final AtomicLong counter = new AtomicLong();
	// 儲存所有使用者的待辦工作
	private static HashMap<String, TodoList> allMap = new HashMap<String, TodoList>();

	@RequestMapping("/api/CreateOrGetList")
	public TodoList GetList(@RequestParam(value = "name", defaultValue = "Brian") String name) {
		TodoList result = null;
		result = this.allMap.get(name) == null ? new TodoList(counter.incrementAndGet(), name) : this.allMap.get(name);

		return result;
	} // GetList

	@RequestMapping("/api/AddWork")
	public TodoList AddWork(@RequestParam(value = "name", defaultValue = "Brian") String name,
			@RequestParam(value = "work", defaultValue = "Learn Vue.js") String work) {
		TodoList result = null;
		result = this.allMap.get(name) == null ? new TodoList(counter.incrementAndGet(), name) : this.allMap.get(name);

		result.getList().add(new Work(work));
		this.allMap.put(name, result);
		return result;
	} // AddWork

	@RequestMapping("/api/RemoveWork")
	public TodoList RemoveWork(@RequestParam(value = "name", defaultValue = "Brian") String name,
			@RequestParam(value = "work") String work) {
		TodoList result = null;
		result = this.allMap.get(name) == null ? new TodoList(counter.incrementAndGet(), name) : this.allMap.get(name);
		result.RemoveWork(work);
		
		this.allMap.put(name, result);
		return result;
	} // RemoveWork

	@RequestMapping("/api/UpdateWork")
	public TodoList UpdateWork(@RequestParam(value = "name", defaultValue = "Brian") String name,
			@RequestParam(value = "oldwork", defaultValue = "Learn Vue.js") String oldwork,
			@RequestParam(value = "newwork", defaultValue = "Learn C#") String newwork) {
		TodoList result = null;
		result = this.allMap.get(name) == null ? new TodoList(counter.incrementAndGet(), name) : this.allMap.get(name);
		result.UpdateWork(oldwork, newwork);
		
		this.allMap.put(name, result);
		return result;
	} // RemoveWork
}
