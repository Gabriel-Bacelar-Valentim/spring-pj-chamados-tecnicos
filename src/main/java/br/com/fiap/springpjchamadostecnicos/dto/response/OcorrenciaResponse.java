package br.com.fiap.springpjchamadostecnicos.dto.response;

import java.time.LocalDateTime;

public record OcorrenciaResponse(


        Long id,

        String descricao,

        ChamadoResponse chamado,

        LocalDateTime data

) {
}
