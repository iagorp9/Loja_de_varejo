package br.com.nicolasmelos.loja_varejo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IService<E> {
    E insert(E object);
    List<E> findAll();
    Optional<E> findById(UUID id);
    E update(E object);
    void delete(UUID id);
}
