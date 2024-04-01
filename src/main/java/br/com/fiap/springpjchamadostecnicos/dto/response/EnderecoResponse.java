package br.com.fiap.springpjchamadostecnicos.dto.response;

public record EnderecoResponse(

        Long id,
        String cep,
        String numero,
        String complemento,
        SolicitanteResponse solicitante

) {
}
