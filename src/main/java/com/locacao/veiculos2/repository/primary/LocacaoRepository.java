package com.locacao.veiculos2.repository.primary;

import com.locacao.veiculos2.model.primary.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    // Derived query
    List<Locacao> findByClienteId(Long clienteId);
    List<Locacao> findByVeiculoId(Long veiculoId);

    // JPQL
    @Query("SELECT l FROM Locacao l WHERE l.valorTotal > :valor")
    List<Locacao> buscarPorValorAcimaDe(double valor);

    // SQL Nativo
    @Query(value = "SELECT * FROM locacoes WHERE cliente_id = :clienteId ORDER BY data_inicio DESC",
           nativeQuery = true)
    List<Locacao> buscarLocacoesClienteOrdenadas(Long clienteId);

    // JOIN FETCH - carrega cliente e veiculo junto com a locacao
    @Query("SELECT l FROM Locacao l JOIN FETCH l.cliente JOIN FETCH l.veiculo WHERE l.id = :id")
    java.util.Optional<Locacao> buscarComClienteEVeiculo(Long id);
}
