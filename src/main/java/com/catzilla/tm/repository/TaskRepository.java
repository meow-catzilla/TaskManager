package com.catzilla.tm.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catzilla.tm.entity.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {

}
