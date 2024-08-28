package com.meubronze.app.service;

import org.springframework.stereotype.Service;

import com.meubronze.app.domain.Config;
import com.meubronze.app.exception.BadRequestException;
import com.meubronze.app.mapper.ConfigMapper;
import com.meubronze.app.repository.ConfigRepository;
import com.meubronze.app.request.config.ConfigPostRequestBody;
import com.meubronze.app.request.config.ConfigPutRequestBody;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConfigService {
    private final ConfigRepository configRepository;
    
    private Config findByIdOrThrowBadRequestException(Long id) throws BadRequestException {
        return this.configRepository.findById(id).orElseThrow(() -> new BadRequestException(String.format("Config %d not found", id)));
    }

    public Config selectConfig() {
        return this.configRepository.findTopByOrderByIdDesc();
    }

    @Transactional(rollbackOn = Exception.class)
    public Config insertConfig(ConfigPostRequestBody configPostRequestBody) {
        this.configRepository.save(ConfigMapper.INSTANCE.toConfig(configPostRequestBody));
        return this.selectConfig();
    }
    
    @Transactional(rollbackOn = Exception.class)
    public Long updateConfig(ConfigPutRequestBody configPutRequestBody) throws BadRequestException {
        Long id = configPutRequestBody.getId();
        this.findByIdOrThrowBadRequestException(id);
        Config updatedConfig = ConfigMapper.INSTANCE.toConfig(configPutRequestBody);
        updatedConfig.setId(id);
        configRepository.save(updatedConfig);
        return id;
    }
}
