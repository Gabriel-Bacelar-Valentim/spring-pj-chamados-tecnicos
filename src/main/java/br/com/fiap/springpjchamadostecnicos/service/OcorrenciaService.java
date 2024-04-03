package br.com.fiap.springpjchamadostecnicos.service;

import br.com.fiap.springpjchamadostecnicos.dto.request.AbstractRequest;
import br.com.fiap.springpjchamadostecnicos.dto.request.OcorrenciaRequest;
import br.com.fiap.springpjchamadostecnicos.dto.response.OcorrenciaResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Ocorrencia;
import br.com.fiap.springpjchamadostecnicos.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Service
public class OcorrenciaService implements ServiceDTO<Ocorrencia, OcorrenciaRequest, OcorrenciaResponse, AbstractRequest> {

    @Autowired
    private OcorrenciaRepository repo;

    @Autowired
    private ChamadoService chamadoService;

    @Override
    public Ocorrencia toEntity(OcorrenciaRequest ocorrenciaRequest) {

        var chamado = chamadoService.findByAbstractRequest(ocorrenciaRequest.chamado());

        return Ocorrencia.builder()
                .data(LocalDateTime.now())
                .chamado(chamado)
                .descricao(ocorrenciaRequest.descricao())
                .build();
    }

    @Override
    public OcorrenciaResponse toResponse(Ocorrencia ocorrencia) {
        return new OcorrenciaResponse(
                ocorrencia.getId(),
                ocorrencia.getDescricao(),
                chamadoService.toResponse(ocorrencia.getChamado()),
                ocorrencia.getData()
        );
    }

    @Override
    public Collection<OcorrenciaResponse> toResponse(Collection<Ocorrencia> entity) {
        return entity.stream().map(this::toResponse).toList();
    }

    @Override
    public Collection<Ocorrencia> findAll() {
        return repo.findAll();
    }

    @Override
    public Ocorrencia findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Ocorrencia findByAbstractRequest(AbstractRequest a) {
        if (Objects.isNull(a)) return null;
        return repo.findById(a.id()).orElse(null);
    }

    @Override
    public Ocorrencia save(Ocorrencia ocorrencia) {
        return repo.save(ocorrencia);
    }
}
