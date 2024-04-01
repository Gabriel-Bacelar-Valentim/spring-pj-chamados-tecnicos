package br.com.fiap.springpjchamadostecnicos.dto.request;

public record ChamadoRequest(
        String titulo,
        String descricao,
        AbstractRequest solicitante,
        AbstractRequest especialidade
) {
}
