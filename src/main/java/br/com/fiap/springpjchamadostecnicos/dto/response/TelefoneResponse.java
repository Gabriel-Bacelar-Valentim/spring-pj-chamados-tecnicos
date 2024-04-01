package br.com.fiap.springpjchamadostecnicos.dto.response;

public record TelefoneResponse(

        Long id,
        String ddi,
        String ddd,
        String numero,
        SolicitanteResponse solicitante

) {
}
