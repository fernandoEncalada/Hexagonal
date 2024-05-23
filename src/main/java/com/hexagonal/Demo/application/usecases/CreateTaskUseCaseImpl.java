package com.hexagonal.Demo.application.usecases;

import com.hexagonal.Demo.domain.models.Task;
import com.hexagonal.Demo.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.Demo.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
