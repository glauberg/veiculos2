package com.locacao.veiculos2.controller;

import com.locacao.veiculos2.dto.LocacaoRequestDTO;
import com.locacao.veiculos2.dto.LocacaoResponseDTO;
import com.locacao.veiculos2.service.LocacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoService service;

    @PostMapping
    public ResponseEntity<LocacaoResponseDTO> cadastrar(
            @Valid @RequestBody LocacaoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<LocacaoResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocacaoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<LocacaoResponseDTO>> buscarPorCliente(
            @PathVariable Long clienteId) {
        return ResponseEntity.ok(service.buscarPorCliente(clienteId));
    }

    @DeleteMapping("/{id}/encerrar")
    public ResponseEntity<Void> encerrar(@PathVariable Long id) {
        service.encerrar(id);
        return ResponseEntity.noContent().build();
    }
}
