package com.meubronze.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping
    public ResponseEntity<Config> selectConfig() {
        return ResponseEntity.ok(configService.selectConfig());
    }

    /**
     * Insere uma tupla de configuração no banco de dados.
     * @param configPostRequestBody o corpo da solicitação contendo os dados de configuração a serem inseridos.
     * @return o objeto de configuração inserido
     */
    @PostMapping
    public ResponseEntity<Config> insertConfig(ConfigPostRequestBody configPostRequestBody) {
        return new ResponseEntity<>(configService.insertConfig(configPostRequestBody), HttpStatus.CREATED);
    }

    /**
     * Atualiza uma tupla de configuração no banco de dados.
     * @param configPutRequestBody o corpo da solicitação contendo os dados de configuração a serem atualizados.
     * @return o valor ID da tupla de configuração atualizada.
     */
    @PutMapping
    public ResponseEntity<Long> updateConfig(ConfigPutRequestBody configPutRequestBody) {
        configService.updateConfig(configPutRequestBody);
        return new ResponseEntity<>(configPutRequestBody.getId(), HttpStatus.OK);
    }
}
