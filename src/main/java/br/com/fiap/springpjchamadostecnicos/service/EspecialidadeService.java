package br.com.fiap.springpjchamadostecnicos.service;

import br.com.fiap.springpjchamadostecnicos.dto.response.EspecialidadeResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Especialidade;
import br.com.fiap.springpjchamadostecnicos.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EspecialidadeService {

    @Autowired
    EspecialidadeRepository repo;

    public EspecialidadeResponse toResponse(Especialidade e) {
        return new EspecialidadeResponse(
                e.getId(),
                e.getNome()
        );
    }

    public List<EspecialidadeResponse> toResponse(Collection<Especialidade> especialidades) {
        return especialidades.stream().map(this::toResponse).toList();
    }


    public Especialidade findById(Long id) {
        return repo.findById(id).orElse(null);
    }

}
