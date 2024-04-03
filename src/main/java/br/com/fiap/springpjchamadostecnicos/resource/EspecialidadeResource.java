package br.com.fiap.springpjchamadostecnicos.resource;


import br.com.fiap.springpjchamadostecnicos.dto.request.EspecialidadeRequest;
import br.com.fiap.springpjchamadostecnicos.dto.response.EspecialidadeResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Especialidade;
import br.com.fiap.springpjchamadostecnicos.repository.EspecialidadeRepository;
import br.com.fiap.springpjchamadostecnicos.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/especialidade")
public class EspecialidadeResource {

    @Autowired
    private EspecialidadeService service;

    @GetMapping
    public List<EspecialidadeResponse> findAll() {
        return service.findAll().stream().map(service::toResponse).toList();
    }

    @GetMapping(value = "/{id}")
    public EspecialidadeResponse findById(@PathVariable Long id) {
        return service.toResponse(service.findById(id));
    }

    @Transactional
    @PostMapping
    public EspecialidadeResponse save(@RequestBody EspecialidadeRequest especialidade) {
        var entity = service.toEntity(especialidade);
        return service.toResponse(service.save(entity));
    }


}
