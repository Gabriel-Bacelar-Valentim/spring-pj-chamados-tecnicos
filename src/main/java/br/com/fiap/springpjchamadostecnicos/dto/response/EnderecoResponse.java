package br.com.fiap.springpjchamadostecnicos.dto.response;

import lombok.Builder;

@Builder
public record EnderecoResponse(

        Long id,
        String cep,
        String numero,
        String complemento,
        SolicitanteResponse solicitante

) {
}
