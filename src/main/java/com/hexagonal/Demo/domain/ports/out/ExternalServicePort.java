package com.hexagonal.Demo.domain.ports.out;

import com.hexagonal.Demo.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo get(Long id);
}
