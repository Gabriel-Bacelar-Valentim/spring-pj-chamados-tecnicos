package br.com.fiap.springpjchamadostecnicos.dto.response;

import java.util.Collection;
import java.util.Set;


public record TecnicoResponse(

        Long id,
        String nome,
        Collection<EspecialidadeResponse> especialidade
) {
}
