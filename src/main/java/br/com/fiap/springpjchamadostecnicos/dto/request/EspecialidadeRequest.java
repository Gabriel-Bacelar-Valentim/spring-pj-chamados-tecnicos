package br.com.fiap.springpjchamadostecnicos.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EspecialidadeRequest(

        @Size(min = 3, max = 255)
        @NotNull(message = "O nome da especialidade deve ser informado")
        String nome

) {
}
