package br.com.fiap.springpjchamadostecnicos.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TecnicoRequest(

        @Size(min = 5, max = 255)
        @NotNull(message = "O nome do tecnico não pode ser nulo")
        String nome
) {
}
