package br.com.fiap.springpjchamadostecnicos.dto.request;

public record EnderecoRequest(

        String cep,
        String numero,
        String complemento

) {
}
