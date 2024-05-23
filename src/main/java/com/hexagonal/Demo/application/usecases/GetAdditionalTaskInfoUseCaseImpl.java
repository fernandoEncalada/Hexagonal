package com.hexagonal.Demo.application.usecases;

import com.hexagonal.Demo.domain.models.AdditionalTaskInfo;
import com.hexagonal.Demo.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.Demo.domain.ports.out.ExternalServicePort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo get(Long id) {
        return externalServicePort.get(id);
    }
}
