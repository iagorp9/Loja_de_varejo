package br.com.nicolasmelos.loja_varejo.repository;

import br.com.nicolasmelos.loja_varejo.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProviderRepository extends JpaRepository<Provider,UUID> {
    Optional<Provider> findByName(String name);
}
