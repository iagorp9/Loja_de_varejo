package br.com.nicolasmelos.loja_varejo.repository;

import br.com.nicolasmelos.loja_varejo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
