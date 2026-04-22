package com.locacao.veiculos2.model.audit;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_auditoria")
public class LogAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String entidade;

    @Column(nullable = false)
    private Long entidadeId;

    @Column(nullable = false)
    private String operacao;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    public LogAuditoria() {}

    public LogAuditoria(String entidade, Long entidadeId, String operacao) {
        this.entidade = entidade;
        this.entidadeId = entidadeId;
        this.operacao = operacao;
        this.dataHora = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEntidade() { return entidade; }
    public void setEntidade(String entidade) { this.entidade = entidade; }

    public Long getEntidadeId() { return entidadeId; }
    public void setEntidadeId(Long entidadeId) { this.entidadeId = entidadeId; }

    public String getOperacao() { return operacao; }
    public void setOperacao(String operacao) { this.operacao = operacao; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}
