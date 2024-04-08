package br.com.fiap.springpjchamadostecnicos.dto.response;

import lombok.Builder;

@Builder
public record TelefoneResponse(

        Long id,
        String ddi,
        String ddd,
        String numero,
        SolicitanteResponse solicitante

) {
}
