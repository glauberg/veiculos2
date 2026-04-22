package com.locacao.veiculos2.service;

import com.locacao.veiculos2.model.audit.LogAuditoria;
import com.locacao.veiculos2.repository.audit.LogAuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditoriaService {

    @Autowired
    private LogAuditoriaRepository logRepository;

    @Transactional("auditTransactionManager")
    public void registrar(String entidade, Long entidadeId, String operacao) {
        LogAuditoria log = new LogAuditoria(entidade, entidadeId, operacao);
        logRepository.save(log);
    }
}
