package br.com.fiap.springpjchamadostecnicos.dto.request;


public record TelefoneRequest(

        String ddi,
        String ddd,
        String numero

) {
}
