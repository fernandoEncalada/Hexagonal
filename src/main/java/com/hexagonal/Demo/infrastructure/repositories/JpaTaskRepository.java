package com.hexagonal.Demo.infrastructure.repositories;

import com.hexagonal.Demo.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
