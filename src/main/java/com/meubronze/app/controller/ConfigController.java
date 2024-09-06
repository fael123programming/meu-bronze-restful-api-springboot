package com.meubronze.app.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.meubronze.app.domain.Config;
import com.meubronze.app.request.config.ConfigPostRequestBody;
import com.meubronze.app.request.config.ConfigPutRequestBody;
import com.meubronze.app.service.ConfigService;

import lombok.RequiredArgsConstructor;

/**
 * Controller para gerenciar os endpoints de acesso e atualização de tuplas
 * de configuração da aplicação no banco de dados.
 */
@RestController
@RequestMapping("config")
@RequiredArgsConstructor
public class ConfigController {
    private final ConfigService configService;

    /**
     * Acessa a última tupla de configuração da aplicação.
     * @return a tupla de configuração vigente, isto é, a última inserida.
     */
    @GetMapping(path = "get")
    public ResponseEntity<Config> selectConfig() {
        return ResponseEntity.ok(configService.selectConfig());
    }

    /**
     * Insere uma tupla de configuração no banco de dados.
     * @param configPostRequestBody o corpo da solicitação contendo os dados de configuração a serem inseridos.
     * @return o objeto de configuração inserido
     */
    @PostMapping(path = "/post")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Config> insertConfig(@RequestBody @Valid ConfigPostRequestBody configPostRequestBody) {
        return new ResponseEntity<>(configService.insertConfig(configPostRequestBody), HttpStatus.CREATED);
    }

    /**
     * Atualiza uma tupla de configuração no banco de dados.
     * @param configPutRequestBody o corpo da solicitação contendo os dados de configuração a serem atualizados.
     * @return o valor ID da tupla de configuração atualizada.
     */
    @PutMapping(path = "/put")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Long> updateConfig(@RequestBody ConfigPutRequestBody configPutRequestBody) {
        configService.updateConfig(configPutRequestBody);
        return new ResponseEntity<>(configPutRequestBody.getId(), HttpStatus.OK);
    }
}
