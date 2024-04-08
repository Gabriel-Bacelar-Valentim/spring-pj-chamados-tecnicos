package br.com.fiap.springpjchamadostecnicos.service;

import br.com.fiap.springpjchamadostecnicos.dto.request.AbstractRequest;
import br.com.fiap.springpjchamadostecnicos.dto.request.TecnicoRequest;
import br.com.fiap.springpjchamadostecnicos.dto.response.TecnicoResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Tecnico;
import br.com.fiap.springpjchamadostecnicos.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;


@Service
public class TecnicoService implements ServiceDTO<Tecnico, TecnicoRequest, TecnicoResponse, AbstractRequest> {

    @Autowired
    EspecialidadeService especialidadeService;


    @Autowired
    private TecnicoRepository repo;


    @Override
    public TecnicoResponse toResponse(Tecnico t) {


        return new TecnicoResponse(
                t.getId(),
                t.getNome(),
                especialidadeService.toResponse(t.getEspecialidades()
                )
        );
    }

    @Override
    public Tecnico toEntity(TecnicoRequest tecnicoRequest) {
        return Tecnico.builder()
                .nome(tecnicoRequest.nome())
                .build();
    }


    @Override
    public Collection<TecnicoResponse> toResponse(Collection<Tecnico> entity) {
        return entity.stream().map(this::toResponse).toList();
    }

    @Override
    public Collection<Tecnico> findAll() {
        return repo.findAll();
    }

    @Override
    public Tecnico findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Tecnico findByAbstractRequest(AbstractRequest a) {
        if (Objects.isNull(a)) return null;
        return repo.findById(a.id()).orElse(null);
    }

    @Override
    public Tecnico save(Tecnico tecnico) {
        return repo.save(tecnico);
    }
}
