package com.locacao.veiculos2.repository.primary;

import com.locacao.veiculos2.model.primary.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Derived query
    Optional<Cliente> findByCpf(String cpf);

    // JPQL
    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Cliente> buscarPorNome(String nome);

    // SQL Nativo
    @Query(value = "SELECT * FROM clientes WHERE email = :email",
           nativeQuery = true)
    Optional<Cliente> buscarPorEmailNativo(String email);

    // JOIN FETCH - carrega locacoes junto com o cliente
    @Query("SELECT c FROM Cliente c LEFT JOIN FETCH c.locacoes WHERE c.id = :id")
    Optional<Cliente> buscarComLocacoes(Long id);
}
