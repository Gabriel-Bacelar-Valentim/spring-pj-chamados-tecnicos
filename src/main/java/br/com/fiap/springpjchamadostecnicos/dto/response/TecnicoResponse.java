package br.com.fiap.springpjchamadostecnicos.dto.response;

import lombok.Builder;

import java.util.Collection;
import java.util.Set;

@Builder
public record TecnicoResponse(

        Long id,
        String nome,
        Collection<EspecialidadeResponse> especialidade
) {
}
