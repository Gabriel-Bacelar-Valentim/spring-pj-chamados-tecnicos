package br.com.fiap.springpjchamadostecnicos.service;

import br.com.fiap.springpjchamadostecnicos.dto.request.AbstractRequest;
import br.com.fiap.springpjchamadostecnicos.dto.request.EnderecoRequest;
import br.com.fiap.springpjchamadostecnicos.dto.response.EnderecoResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Endereco;
import br.com.fiap.springpjchamadostecnicos.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EnderecoService implements ServiceDTO<Endereco, EnderecoRequest, EnderecoResponse, AbstractRequest> {

    @Autowired
    private EnderecoRepository repo;


    @Autowired
    private SolicitanteService solicitanteService;

    @Override
    public Endereco toEntity(EnderecoRequest enderecoRequest) {

        return Endereco.builder()
                .cep(enderecoRequest.cep())
                .numero(enderecoRequest.numero())
                .complemento(enderecoRequest.complemento())
                .build();
    }

    @Override
    public EnderecoResponse toResponse(Endereco endereco) {

        var solicitante = solicitanteService.toResponse(endereco.getSolicitante());

        return EnderecoResponse.builder()
                .solicitante(solicitante)
                .cep(endereco.getCep())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .id(endereco.getId())
                .build();
    }

    @Override
    public Collection<EnderecoResponse> toResponse(Collection<Endereco> entity) {
        return entity.stream().map(this::toResponse).toList();
    }

    @Override
    public Collection<Endereco> findAll() {
        return repo.findAll();
    }

    @Override
    public Endereco findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Endereco findByAbstractRequest(AbstractRequest a) {
        return repo.findById(a.id()).orElse(null);
    }

    @Override
    public Endereco save(Endereco endereco) {
        return repo.save(endereco);
    }

    public List<Endereco> findBySolicitanteId(Long id) {
        return repo.findBySolicitanteId(id);
    }
}
