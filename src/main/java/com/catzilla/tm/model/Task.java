package com.catzilla.tm.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(value = Include.NON_NULL)
@JsonPropertyOrder({
	"uid",
	"task",
	"discription",
	"createdOn",
	"updatedOn"
})
public class Task {

	@JsonProperty("uid")
	private UUID uid;
	
	@JsonProperty("task")
	private String task;
	
	@JsonProperty("discription")
	private String discription;
	
	@JsonProperty("createdOn")	
	private String createdOn;
	
	@JsonProperty("updatedOn")
	private String updatedOn;

	public UUID getUid() {
		return uid;
	}

	public void setUid(UUID uid) {
		this.uid = uid;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "Task [uid=" + uid + ", task=" + task + ", discription=" + discription + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + "]";
	}
	
}
