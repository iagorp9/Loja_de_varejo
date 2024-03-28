package br.com.nicolasmelos.loja_varejo.dto;

import br.com.nicolasmelos.loja_varejo.model.Provider;


import java.util.UUID;

public record ProductDto(
        UUID id,
        Provider provider,
        float cost
) {
}
