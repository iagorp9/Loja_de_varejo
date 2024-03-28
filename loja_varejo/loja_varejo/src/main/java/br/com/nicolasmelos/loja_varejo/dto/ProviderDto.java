package br.com.nicolasmelos.loja_varejo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.util.UUID;

public record ProviderDto(
        UUID id,
        @NotBlank(message = "O campo nome não pode ficar em branco!!!")
        String name,
        @NotBlank(message = "O campo cnpj não pode ficar em branco!!!")
        String cnpj,
        @NotBlank(message = "O campo telefone não pode ficar em branco!!!")
        String phone,
        @NotBlank(message = "O campo email não pode ficar em branco!!!")
        @Email(message = "O email digitado não é válido!!!")
        String email

) {
}
