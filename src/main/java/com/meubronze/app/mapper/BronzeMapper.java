package com.meubronze.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.meubronze.app.domain.Bronze;
import com.meubronze.app.request.bronze.BronzePostRequestBody;
import com.meubronze.app.request.bronze.BronzePutRequestBody;

@Mapper(componentModel = "spring")
public abstract class BronzeMapper {
    public static final BronzeMapper INSTANCE = Mappers.getMapper(BronzeMapper.class);

    public abstract Bronze toBronze(BronzePostRequestBody bronzePostRequestBody);

    public abstract Bronze toBronze(BronzePutRequestBody bronzePutRequestBody);
}
