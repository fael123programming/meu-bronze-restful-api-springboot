package com.meubronze.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meubronze.app.domain.Bronze;
import com.meubronze.app.request.bronze.BronzeDeleteRequestBody;
import com.meubronze.app.request.bronze.BronzePostRequestBody;
import com.meubronze.app.service.BronzeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("bronze")
@RequiredArgsConstructor
public class BronzeController {
    private final BronzeService bronzeService;

    /**
     *  Acessa os bronzes da aplicação salvos no banco de dados.
     * @return uma lista contendo os bronzes da aplicação.
     */
    @GetMapping
    public ResponseEntity<List<Bronze>> selectAllBronzes() {
        return ResponseEntity.ok(this.bronzeService.selectAllBronzes());
    }

    /**
     * Insere um novo bronze no banco de dados.
     * @param bronzePostRequestBody o corpo da requisição contendo os dados do bronze para serem salvos.
     * @return o ID do novo bronze inserido no banco de dados da aplicação.
     */
    @PostMapping
    public ResponseEntity<Long> insertBronze(@RequestBody BronzePostRequestBody bronzePostRequestBody) {
        return new ResponseEntity<>(this.bronzeService.insertBronze(bronzePostRequestBody), HttpStatus.CREATED);
    }

    /**
     * Deleta múltiplos bronzes utilizando o ID de cada um.
     * @param bronzeDeleteRequestBody o corpo da requisição contendo os IDs dos bronzes para serem removidos.
     * @return o ID do último bronze deletado.
     */
    @DeleteMapping
    public ResponseEntity<Long> deleteBronzes(@RequestBody BronzeDeleteRequestBody bronzeDeleteRequestBody) {
        return ResponseEntity.ok(this.bronzeService.deleteBronzes(bronzeDeleteRequestBody));
    }
}
