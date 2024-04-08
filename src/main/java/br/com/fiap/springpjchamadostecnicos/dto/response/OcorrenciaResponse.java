package br.com.fiap.springpjchamadostecnicos.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record OcorrenciaResponse(


        Long id,

        String descricao,

        ChamadoResponse chamado,

        LocalDateTime data

) {
}
