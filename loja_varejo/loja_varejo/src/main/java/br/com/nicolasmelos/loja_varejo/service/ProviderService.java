package br.com.nicolasmelos.loja_varejo.service;

import br.com.nicolasmelos.loja_varejo.model.Provider;
import br.com.nicolasmelos.loja_varejo.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProviderService implements IService<Provider> {
    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Provider insert(Provider object) {
        return providerRepository.save(object);
    }

    @Override
    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    @Override
    public Optional<Provider> findById(UUID id) {
        return providerRepository.findById(id);
    }

    @Override
    public Provider update(Provider object) {
        return providerRepository.save(object);
    }

    @Override
    public void delete(UUID id) {
        providerRepository.deleteById(id);
    }

    public Optional<Provider> findByName(String name){
        return providerRepository.findByName(name);
    }
}
