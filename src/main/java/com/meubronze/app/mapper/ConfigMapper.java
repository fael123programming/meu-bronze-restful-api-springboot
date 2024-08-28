package com.meubronze.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.meubronze.app.domain.Config;
import com.meubronze.app.request.config.ConfigPostRequestBody;
import com.meubronze.app.request.config.ConfigPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class ConfigMapper {
    public static final ConfigMapper INSTANCE = Mappers.getMapper(ConfigMapper.class);

    public abstract Config toConfig(ConfigPostRequestBody configPostRequestBody);

    public abstract Config toConfig(ConfigPutRequestBody configPutRequestBody);
}
