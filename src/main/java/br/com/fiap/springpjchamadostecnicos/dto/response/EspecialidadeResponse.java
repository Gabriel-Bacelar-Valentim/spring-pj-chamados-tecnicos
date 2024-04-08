package br.com.fiap.springpjchamadostecnicos.dto.response;

import lombok.Builder;

@Builder
public record EspecialidadeResponse(

        Long id,

        String nome

) {
}
