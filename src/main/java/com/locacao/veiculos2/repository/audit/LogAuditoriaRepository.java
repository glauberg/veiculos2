package com.locacao.veiculos2.repository.audit;

import com.locacao.veiculos2.model.audit.LogAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogAuditoriaRepository extends JpaRepository<LogAuditoria, Long> {

    // Derived query
    List<LogAuditoria> findByEntidade(String entidade);
    List<LogAuditoria> findByEntidadeId(Long entidadeId);

    // JPQL
    @Query("SELECT l FROM LogAuditoria l WHERE l.operacao = :operacao ORDER BY l.dataHora DESC")
    List<LogAuditoria> buscarPorOperacao(String operacao);

    // SQL Nativo
    @Query(value = "SELECT * FROM log_auditoria ORDER BY data_hora DESC LIMIT 50",
           nativeQuery = true)
    List<LogAuditoria> buscarUltimos50Logs();
}
