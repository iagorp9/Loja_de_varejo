package br.com.nicolasmelos.loja_varejo.service;

import br.com.nicolasmelos.loja_varejo.model.Product;
import br.com.nicolasmelos.loja_varejo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements IService<Product>{
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insert(Product object) {
        return productRepository.save(object);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public Product update(Product object) {
        return productRepository.save(object);
    }

    @Override
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }
}
