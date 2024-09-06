package com.meubronze.app.service;

import java.util.List;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.meubronze.app.domain.Client;
import com.meubronze.app.exception.BadRequestException;
import com.meubronze.app.mapper.ClientMapper;
import com.meubronze.app.repository.ClientRepository;
import com.meubronze.app.request.client.ClientPostRequestBody;
import com.meubronze.app.request.client.ClientPutRequestBody;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> selectAllClients() {
        return this.clientRepository.findAll();
    }

    public Client findByIdOrThrowBadRequestException(Long id) throws BadRequestException {
        return this.clientRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(String.format("Client %d not found", id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public Long insertClient(ClientPostRequestBody clientPostRequestBody) {
        log.info(clientPostRequestBody);
        Client client = this.clientRepository.save(ClientMapper.INSTANCE.toClient(clientPostRequestBody));
//        log.info(client);
        return client.getId();
    }

    @Transactional(rollbackOn = Exception.class)
    public Long updateClient(ClientPutRequestBody clientPutRequestBody) throws BadRequestException {
        Long id = clientPutRequestBody.getId();
        this.findByIdOrThrowBadRequestException(id);
        Client updatedClient = ClientMapper.INSTANCE.toClient(clientPutRequestBody);
        updatedClient.setId(id);
        this.clientRepository.save(updatedClient);
        return id;
    }

    @Transactional(rollbackOn = Exception.class)
    public Long deleteClient(long clientId) throws BadRequestException {
        this.clientRepository.delete(this.findByIdOrThrowBadRequestException(clientId));
        return clientId;
    }
}
