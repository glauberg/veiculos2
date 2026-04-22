package com.locacao.veiculos2.controller;

import com.locacao.veiculos2.dto.VeiculoRequestDTO;
import com.locacao.veiculos2.dto.VeiculoResponseDTO;
import com.locacao.veiculos2.enums.CategoriaVeiculo;
import com.locacao.veiculos2.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> cadastrar(
            @Valid @RequestBody VeiculoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<VeiculoResponseDTO>> buscarDisponiveisPorCategoria(
            @RequestParam CategoriaVeiculo categoria) {
        return ResponseEntity.ok(service.buscarDisponiveisPorCategoria(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody VeiculoRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
