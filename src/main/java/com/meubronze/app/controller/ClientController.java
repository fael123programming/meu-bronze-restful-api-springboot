package com.meubronze.app.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meubronze.app.domain.Client;
import com.meubronze.app.request.client.ClientPostRequestBody;
import com.meubronze.app.request.client.ClientPutRequestBody;
import com.meubronze.app.service.ClientService;

import lombok.RequiredArgsConstructor;

/**
 * Controller para gerenciar os endpoints de acesso, atualização e deleção de clientes
 * da aplicação no banco de dados.
 */
@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    /**
     * Acessa os clientes da aplicação salvos no banco de dados.
     * @return uma lista contendo os clientes da aplicação.
     */
    @GetMapping(path = "all")
    public ResponseEntity<List<Client>> selectAllClients() {
        return ResponseEntity.ok(this.clientService.selectAllClients());
    }

    /**
     * Insere um novo cliente no banco de dados.
     * @param clientPostRequestBody o corpo da requisição contendo os dados do cliente para serem salvos.
     * @return o ID do novo cliente inserido no banco de dados da aplicação.
     */
    @PostMapping(path = "/post")
    public ResponseEntity<Long> insertClient(@RequestBody @Valid ClientPostRequestBody clientPostRequestBody) {
        return new ResponseEntity<>(this.clientService.insertClient(clientPostRequestBody), HttpStatus.CREATED);
    }

    /**
     * Deleta um cliente no banco de dados.
     * @param clientId o ID do cliente para ser removido.
     * @return o ID do cliente deletado do banco de dados da aplicação.
     */
    @DeleteMapping(path = "/delete/{clientId}")
    public ResponseEntity<Long> deleteClient(@PathVariable long clientId) {
        return ResponseEntity.ok(this.clientService.deleteClient(clientId));
    }

    /**
     * Atualiza um cliente no banco de dados.
     * @param clientPutRequestBody o corpo da requisição contendo os dados do cliente para ser atualizado.
     * @return o ID do cliente atualizado.
     */
    @PutMapping(path = "/put")
    public ResponseEntity<Long> updateClient(@RequestBody ClientPutRequestBody clientPutRequestBody) {
        return ResponseEntity.ok(this.clientService.updateClient(clientPutRequestBody));
    }
}
