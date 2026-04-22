package com.locacao.veiculos2.controller;

import com.locacao.veiculos2.dto.AcessorioRequestDTO;
import com.locacao.veiculos2.dto.AcessorioResponseDTO;
import com.locacao.veiculos2.service.AcessorioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acessorios")
public class AcessorioController {

    @Autowired
    private AcessorioService service;

    @PostMapping
    public ResponseEntity<AcessorioResponseDTO> cadastrar(
            @Valid @RequestBody AcessorioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<AcessorioResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcessorioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcessorioResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody AcessorioRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}