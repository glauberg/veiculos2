package com.locacao.veiculos2.repository.primary;

import com.locacao.veiculos2.enums.CategoriaVeiculo;
import com.locacao.veiculos2.model.primary.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    // JPQL
    @Query("SELECT v FROM Veiculo v WHERE v.categoria = :categoria AND v.disponivel = true")
    List<Veiculo> buscarDisponiveisPorCategoria(CategoriaVeiculo categoria);

    // SQL Nativo
    @Query(value = "SELECT * FROM veiculos WHERE disponivel = true",
           nativeQuery = true)
    List<Veiculo> buscarTodosDisponiveisNativo();

    // JOIN FETCH - controle EAGER sobre relacionamento LAZY
    @Query("SELECT v FROM Veiculo v LEFT JOIN FETCH v.acessorios WHERE v.id = :id")
    Optional<Veiculo> buscarComAcessorios(Long id);
}
