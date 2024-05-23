package com.hexagonal.Demo.application.usecases;

import com.hexagonal.Demo.domain.models.Task;
import com.hexagonal.Demo.domain.ports.in.UpdateTaskUseCase;
import com.hexagonal.Demo.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskRepositoryPort.update(id, updateTask);
    }
}
