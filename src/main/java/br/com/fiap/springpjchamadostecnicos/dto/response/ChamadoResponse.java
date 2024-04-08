package br.com.fiap.springpjchamadostecnicos.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;


@Builder
public record ChamadoResponse(
        Long id,
        String titulo,
        String descricao,
        EspecialidadeResponse especialidade,
        TecnicoResponse tecnico,
        SolicitanteResponse solicitante,
        LocalDateTime dataAbertura,
        LocalDateTime dataPrimeiroAtendimento,
        LocalDateTime dataEncerramento
) {
}
