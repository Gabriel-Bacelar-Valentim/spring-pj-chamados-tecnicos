package br.com.fiap.springpjchamadostecnicos.dto.response;

import java.time.LocalDateTime;

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
