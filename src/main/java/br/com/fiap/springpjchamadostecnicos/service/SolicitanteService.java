package br.com.fiap.springpjchamadostecnicos.service;


import br.com.fiap.springpjchamadostecnicos.dto.request.AbstractRequest;
import br.com.fiap.springpjchamadostecnicos.dto.request.SolicitanteRequest;
import br.com.fiap.springpjchamadostecnicos.dto.response.SolicitanteResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Solicitante;
import br.com.fiap.springpjchamadostecnicos.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class SolicitanteService implements ServiceDTO<Solicitante, SolicitanteRequest, SolicitanteResponse, AbstractRequest> {


    @Autowired
    SolicitanteRepository repo;

    @Override
    public Solicitante toEntity(SolicitanteRequest solicitanteRequest) {
        return Solicitante.builder()
                .nome(solicitanteRequest.nome())
                .build();
    }

    @Override
    public SolicitanteResponse toResponse(Solicitante s) {
        return new SolicitanteResponse(s.getId(), s.getNome());
    }

    @Override
    public Collection<SolicitanteResponse> toResponse(Collection<Solicitante> entity) {
        return entity.stream().map(this::toResponse).toList();
    }

    @Override
    public Collection<Solicitante> findAll() {
        return repo.findAll();
    }

    @Override
    public Solicitante findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Solicitante findByAbstractRequest(AbstractRequest a) {
        if (Objects.isNull(a)) return null;
        return repo.findById(a.id()).orElse(null);
    }

    @Override
    public Solicitante save(Solicitante solicitante) {
        return repo.save(solicitante);
    }


}
