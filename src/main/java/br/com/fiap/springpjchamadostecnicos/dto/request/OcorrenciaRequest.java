package br.com.fiap.springpjchamadostecnicos.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record OcorrenciaRequest(

        @Size(min = 10, max = 255)
        @NotNull(message = "A descrição da ocorrência é campo obrigatório")
        String descricao,

        @NotNull(message = "A ocorrência precisa da informação do chamado")
        AbstractRequest chamado

) {
}
