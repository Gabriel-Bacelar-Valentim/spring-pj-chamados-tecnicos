package br.com.fiap.springpjchamadostecnicos.dto.request;

public record OcorrenciaRequest(

        String descricao,

        AbstractRequest chamado

) {
}
