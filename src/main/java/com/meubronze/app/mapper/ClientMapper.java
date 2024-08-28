package com.meubronze.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.meubronze.app.domain.Client;
import com.meubronze.app.request.client.ClientPostRequestBody;
import com.meubronze.app.request.client.ClientPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {
    public static final ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    public abstract Client toClient(ClientPostRequestBody clientPostRequestBody);

    public abstract Client toClient(ClientPutRequestBody clientPutRequestBody);
}
