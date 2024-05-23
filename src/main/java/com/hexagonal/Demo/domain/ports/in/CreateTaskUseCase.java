package com.hexagonal.Demo.domain.ports.in;

import com.hexagonal.Demo.domain.models.Task;

public interface CreateTaskUseCase {

    Task createTask(Task task);
}
