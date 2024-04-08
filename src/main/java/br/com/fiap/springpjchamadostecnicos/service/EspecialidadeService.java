package br.com.fiap.springpjchamadostecnicos.service;

import br.com.fiap.springpjchamadostecnicos.dto.request.AbstractRequest;
import br.com.fiap.springpjchamadostecnicos.dto.request.EspecialidadeRequest;
import br.com.fiap.springpjchamadostecnicos.dto.response.EspecialidadeResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Especialidade;
import br.com.fiap.springpjchamadostecnicos.repository.EspecialidadeRepository;
import lombok.NonNull;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EspecialidadeService implements ServiceDTO<Especialidade, EspecialidadeRequest, EspecialidadeResponse, AbstractRequest> {

    @Autowired
    EspecialidadeRepository repo;

    @Override
    public Especialidade toEntity(EspecialidadeRequest especialidadeRequest) {
        return Especialidade.builder()
                .nome(especialidadeRequest.nome())
                .build();
    }

    @Override
    public EspecialidadeResponse toResponse(Especialidade e) {
        return new EspecialidadeResponse(
                e.getId(),
                e.getNome()
        );
    }

    @Override
    public List<EspecialidadeResponse> toResponse(@NonNull Collection<Especialidade> especialidades) {
        return especialidades.stream().map(this::toResponse).toList();
    }

    @Override
    public Especialidade findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Especialidade findByAbstractRequest(AbstractRequest a) {
        return repo.findById(a.id()).orElse(null);
    }

    @Override
    public List<Especialidade> findAll() {
        return repo.findAll();
    }

    @Override
    public Especialidade save(Especialidade e) {
        return repo.save(e);
    }

}
