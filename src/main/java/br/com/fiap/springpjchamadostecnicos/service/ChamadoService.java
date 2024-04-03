package br.com.fiap.springpjchamadostecnicos.service;

import br.com.fiap.springpjchamadostecnicos.dto.request.AbstractRequest;
import br.com.fiap.springpjchamadostecnicos.dto.request.ChamadoRequest;
import br.com.fiap.springpjchamadostecnicos.dto.response.ChamadoResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Chamado;
import br.com.fiap.springpjchamadostecnicos.entity.Especialidade;
import br.com.fiap.springpjchamadostecnicos.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Service
public class ChamadoService implements ServiceDTO<Chamado, ChamadoRequest, ChamadoResponse, AbstractRequest> {

    @Autowired
    EspecialidadeService especialidadeService;

    @Autowired
    TecnicoService tecnicoService;

    @Autowired
    SolicitanteService solicitanteService;

    @Autowired
    ChamadoRepository repo;

    public ChamadoResponse toResponse(Chamado c) {
        return new ChamadoResponse(
                c.getId(),
                c.getTitulo(),
                c.getDescricao(),
                especialidadeService.toResponse(c.getEspecialidade()),
                tecnicoService.toResponse(c.getTecnico()),
                solicitanteService.toResponse(c.getSolicitante()),
                c.getDataAbertura(),
                c.getDataPrimeiroAtendimento(),
                c.getDataEncerramento()
        );
    }


    public Chamado toEntity(ChamadoRequest request) {

        Especialidade especialidade = especialidadeService.findById(request.especialidade().id());

        var solicitante = solicitanteService.findById(request.solicitante().id());

        return Chamado.builder()
                .titulo(request.titulo())
                .descricao(request.descricao())
                .especialidade(especialidade)
                .solicitante(solicitante)
                .build();
    }

    public Chamado findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Chamado findByAbstractRequest(AbstractRequest a) {
        if (Objects.isNull(a)) return null;
        return repo.findById(a.id()).orElse(null);
    }

    @Override
    public Collection<ChamadoResponse> toResponse(Collection<Chamado> entity) {
        if (entity.size() > 0)
            return entity.stream().map(this::toResponse).toList();
        return new ArrayList<>();
    }

    public List<Chamado> findAll() {
        return repo.findAll();
    }

    public Chamado save(Chamado entity) {
        return repo.save(entity);
    }
}
