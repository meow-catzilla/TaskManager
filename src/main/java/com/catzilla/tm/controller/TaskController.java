package com.catzilla.tm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catzilla.tm.model.Task;
import com.catzilla.tm.service.TaskService;



@RestController
@RequestMapping(value = "/")
public class TaskController {

	private static final Logger log = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
	private TaskService taskService;
	
	 @GetMapping("tasks")
	 public ResponseEntity<List<Task>> getTasks() {
		 List<Task> tasks = new ArrayList<>();
		 try {
			 tasks = taskService.getTasks();
		 }catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	 	return ResponseEntity.status(HttpStatus.OK).body(tasks);
	 }
	 
	 @GetMapping("task/{uid}")
	 public ResponseEntity<Task> getTask(@PathVariable UUID uid) {
		 Task task = new Task();
		 try {
			 task = taskService.getTask(uid);
		 }catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	 	return ResponseEntity.status(HttpStatus.OK).body(task);
	 }
	 
	 @PostMapping("task")
	 public ResponseEntity<Task> createTask(@RequestBody Task task) {
		 try {
			 task = taskService.createTask(task);
		 }catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		 }
	 	return ResponseEntity.status(HttpStatus.CREATED).body(task);
	 }
	 
	 @PutMapping("task")
	 public ResponseEntity<Void> updateTask(@RequestBody Task task) {
		 try {
			 taskService.updateTask(task);
		 }catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		 }
	 	return ResponseEntity.status(HttpStatus.OK).build();
	 }
	 
	 @DeleteMapping("task/{uid}")
	 public ResponseEntity<Void> deleteTask(@PathVariable UUID uid){
		 try {
			 taskService.deleteTask(uid);
		 }catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		 }
	 	return ResponseEntity.status(HttpStatus.OK).build();
	 }
}
