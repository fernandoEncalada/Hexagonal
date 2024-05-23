package com.hexagonal.Demo.domain.ports.in;

import com.hexagonal.Demo.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Task> getTask(Long id);

    List<Task> getAllTasks();
}
