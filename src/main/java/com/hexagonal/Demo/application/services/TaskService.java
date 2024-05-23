package com.hexagonal.Demo.application.services;

import com.hexagonal.Demo.domain.models.AdditionalTaskInfo;
import com.hexagonal.Demo.domain.models.Task;
import com.hexagonal.Demo.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.Demo.domain.ports.in.DeleteTaskUseCase;
import com.hexagonal.Demo.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.Demo.domain.ports.in.RetrieveTaskUseCase;
import com.hexagonal.Demo.domain.ports.in.UpdateTaskUseCase;

import java.util.List;
import java.util.Optional;

public class TaskService implements CreateTaskUseCase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase, RetrieveTaskUseCase, UpdateTaskUseCase {

    private final CreateTaskUseCase createTaskUseCase;

    private final DeleteTaskUseCase deleteTaskUseCase;

    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    private final RetrieveTaskUseCase retrieveTaskUseCase;

    private final UpdateTaskUseCase updateTaskUseCase;

    public TaskService(CreateTaskUseCase createTaskUseCase, DeleteTaskUseCase deleteTaskUseCase, RetrieveTaskUseCase retrieveTaskUseCase,
                       UpdateTaskUseCase updateTaskUseCase, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo get(Long id) {
        return getAdditionalTaskInfoUseCase.get(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return retrieveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return updateTaskUseCase.updateTask(id, updateTask);
    }
}
