package com.hexagonal.Demo.domain.ports.in;

import com.hexagonal.Demo.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {

    AdditionalTaskInfo get(Long id);
}
