package br.com.fiap.springpjchamadostecnicos.dto.response;

import lombok.Builder;

@Builder
public record SolicitanteResponse(

        Long id,

        String nome

) {
}
