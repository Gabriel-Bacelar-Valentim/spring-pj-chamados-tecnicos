package br.com.fiap.springpjchamadostecnicos.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TelefoneRequest(
        @NotNull(message = "O DDI do telefone não pode ser nulo")
        String ddi,

        @NotNull(message = "O DDD do telefone não pode ser nulo")
        String ddd,

        @NotNull(message = "O número do telefone não pode ser nulo")
        String numero

) {
}
