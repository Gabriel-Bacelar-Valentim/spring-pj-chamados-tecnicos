package br.com.fiap.springpjchamadostecnicos.resource;

import br.com.fiap.springpjchamadostecnicos.dto.request.AbstractRequest;
import br.com.fiap.springpjchamadostecnicos.dto.request.EspecialidadeRequest;
import br.com.fiap.springpjchamadostecnicos.dto.request.TecnicoRequest;
import br.com.fiap.springpjchamadostecnicos.dto.response.TecnicoResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Especialidade;
import br.com.fiap.springpjchamadostecnicos.entity.Tecnico;
import br.com.fiap.springpjchamadostecnicos.repository.EspecialidadeRepository;
import br.com.fiap.springpjchamadostecnicos.repository.TecnicoRepository;
import br.com.fiap.springpjchamadostecnicos.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/tecnico")
public class TecnicoResource {
    @Autowired
    private TecnicoService service;
    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @GetMapping
    public List<TecnicoResponse> findAll() {
        return service.findAll().stream().map(service::toResponse).toList();
    }

    @GetMapping(value = "/{id}")
    public TecnicoResponse findById(@PathVariable Long id) {
        return service.toResponse(service.findById(id));
    }

    @Transactional
    @PostMapping
    public TecnicoResponse save(@RequestBody TecnicoRequest tecnico) {
        if (Objects.isNull(tecnico)) return null;
        var entity = service.toEntity(tecnico);
        var saved = service.save(entity);
        return service.toResponse(saved);
    }


    @Transactional
    @PostMapping(value = "/{id}/especialidade")
    public TecnicoResponse save(@PathVariable Long id, @RequestBody AbstractRequest especialidade) {
        if (Objects.isNull(especialidade)) return null;
        Tecnico tecnico = service.findById(id);
        Especialidade especialidaeEntity = null;
        if (Objects.nonNull(especialidade.id())) {
            especialidaeEntity = especialidadeRepository.findById(especialidade.id()).orElseThrow();
        }
        tecnico.getEspecialidades().add(especialidaeEntity);
        return service.toResponse(tecnico);
    }

}
