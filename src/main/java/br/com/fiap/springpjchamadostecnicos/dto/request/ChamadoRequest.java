package br.com.fiap.springpjchamadostecnicos.dto.request;

import jakarta.validation.constraints.NotNull;

public record ChamadoRequest(

        @NotNull(message = "O titulo do chamado deve ser informado")
        String titulo,

        @NotNull(message = "A descrição do chamado deve ser informada")
        String descricao,

        @NotNull(message = "O solicitante do chamado é campo obrigatório")
        AbstractRequest solicitante,

        @NotNull(message = "A especialidade do chamado é campo obrigatório")
        AbstractRequest especialidade
) {
}
