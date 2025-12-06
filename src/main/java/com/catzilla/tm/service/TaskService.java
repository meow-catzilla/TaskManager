package com.catzilla.tm.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catzilla.tm.entity.TaskEntity;
import com.catzilla.tm.model.Task;
import com.catzilla.tm.repository.TaskRepository;

@Service
public class TaskService {

	private static final Logger log = LoggerFactory.getLogger(TaskService.class);
	
	@Autowired
	TaskRepository taskRepository;
	
	public List<Task> getTasks(){
		
		List<TaskEntity> taskEntities = taskRepository.findAll();
		
		return taskEntities.stream().map(t -> {
			Task task = new Task();
			task.setUid(t.getUid());
			task.setTask(t.getTask());
			task.setDiscription(t.getDiscription());
			task.setCreatedOn(t.getCreatedOn().format(DateTimeFormatter.ISO_DATE_TIME));
			if(t.getUpdatedOn() != null) {
				task.setUpdatedOn(t.getUpdatedOn().format(DateTimeFormatter.ISO_DATE_TIME));
			}
			return task;
		}).collect(Collectors.toList());
		
	}

	public Task getTask(UUID uid) {
		TaskEntity taskEntity = taskRepository.getReferenceById(uid);
		
		Task task = new Task();
		task.setUid(taskEntity.getUid());
		task.setTask(taskEntity.getTask());
		task.setDiscription(taskEntity.getDiscription());
		task.setCreatedOn(taskEntity.getCreatedOn().format(DateTimeFormatter.ISO_DATE_TIME));
		if(taskEntity.getUpdatedOn() != null) {
			task.setUpdatedOn(taskEntity.getUpdatedOn().format(DateTimeFormatter.ISO_DATE_TIME));
		}
		return task;
	}

	public Task createTask(Task task) {
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setTask(task.getTask());
		taskEntity.setDiscription(task.getDiscription());
		taskEntity.setCreatedOn(LocalDateTime.now());
		taskEntity =  taskRepository.save(taskEntity);
		task.setUid(taskEntity.getUid());
		
		return task;
	}

	public void updateTask(Task task) {

		TaskEntity taskEntity = taskRepository.getReferenceById(task.getUid());
		if(!task.getTask().isEmpty()) {
			taskEntity.setTask(task.getTask());
		}
		if(!task.getDiscription().isEmpty()) {
			taskEntity.setDiscription(task.getDiscription());
		}
		taskEntity.setUpdatedOn(LocalDateTime.now());
		taskEntity =  taskRepository.save(taskEntity);
		log.info("Task Updated");
	}

	public void deleteTask(UUID uid) {
		taskRepository.deleteById(uid);
	}
}
