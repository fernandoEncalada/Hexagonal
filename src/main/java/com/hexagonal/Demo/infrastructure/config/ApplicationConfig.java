package com.hexagonal.Demo.infrastructure.config;

import com.hexagonal.Demo.application.services.TaskService;
import com.hexagonal.Demo.application.usecases.CreateTaskUseCaseImpl;
import com.hexagonal.Demo.application.usecases.DeleteTaskUseCaseImpl;
import com.hexagonal.Demo.application.usecases.GetAdditionalTaskInfoUseCaseImpl;
import com.hexagonal.Demo.application.usecases.RetrieveTaskUseCaseImpl;
import com.hexagonal.Demo.application.usecases.UpdateTaskUseCaseImpl;
import com.hexagonal.Demo.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.Demo.domain.ports.out.ExternalServicePort;
import com.hexagonal.Demo.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.Demo.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonal.Demo.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }
}
