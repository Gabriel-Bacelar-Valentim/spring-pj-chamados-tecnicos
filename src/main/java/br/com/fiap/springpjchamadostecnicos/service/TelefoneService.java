package br.com.fiap.springpjchamadostecnicos.service;

import br.com.fiap.springpjchamadostecnicos.dto.request.AbstractRequest;
import br.com.fiap.springpjchamadostecnicos.dto.request.TelefoneRequest;
import br.com.fiap.springpjchamadostecnicos.dto.response.TelefoneResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Telefone;
import br.com.fiap.springpjchamadostecnicos.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TelefoneService implements ServiceDTO<Telefone, TelefoneRequest, TelefoneResponse, AbstractRequest> {

    @Autowired
    private TelefoneRepository repo;


    @Autowired
    private SolicitanteService solicitanteService;

    @Override
    public Telefone toEntity(TelefoneRequest telefoneRequest) {

        return Telefone.builder()
                .ddi(telefoneRequest.ddi())
                .ddd(telefoneRequest.ddd())
                .numero(telefoneRequest.numero())
                .build();
    }

    @Override
    public TelefoneResponse toResponse(Telefone telefone) {

        var solicitante = solicitanteService.toResponse(telefone.getSolicitante());

        return TelefoneResponse.builder()
                .solicitante(solicitante)
                .ddi(telefone.getDdi())
                .ddd(telefone.getDdd())
                .numero(telefone.getNumero())
                .id(telefone.getId())
                .build();
    }

    @Override
    public Collection<TelefoneResponse> toResponse(Collection<Telefone> entity) {
        return entity.stream().map(this::toResponse).toList();
    }

    @Override
    public Collection<Telefone> findAll() {
        return repo.findAll();
    }

    @Override
    public Telefone findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Telefone findByAbstractRequest(AbstractRequest a) {
        return repo.findById(a.id()).orElse(null);
    }

    @Override
    public Telefone save(Telefone telefone) {
        return repo.save(telefone);
    }

    public List<Telefone> findBySolicitanteId(Long id) {
        return  repo.findBySolicitanteId(id);
    }
}
