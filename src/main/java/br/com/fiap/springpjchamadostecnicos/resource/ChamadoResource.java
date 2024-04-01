package br.com.fiap.springpjchamadostecnicos.resource;


import br.com.fiap.springpjchamadostecnicos.dto.request.ChamadoRequest;
import br.com.fiap.springpjchamadostecnicos.dto.response.ChamadoResponse;
import br.com.fiap.springpjchamadostecnicos.dto.response.EspecialidadeResponse;
import br.com.fiap.springpjchamadostecnicos.dto.response.TecnicoResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Chamado;
import br.com.fiap.springpjchamadostecnicos.repository.ChamadoRepository;
import br.com.fiap.springpjchamadostecnicos.repository.EspecialidadeRepository;
import br.com.fiap.springpjchamadostecnicos.repository.SolicitanteRepository;
import br.com.fiap.springpjchamadostecnicos.repository.TecnicoRepository;
import br.com.fiap.springpjchamadostecnicos.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/chamado")
public class ChamadoResource {

    @Autowired
    ChamadoService service;

    @GetMapping
    public List<ChamadoResponse> findAll() {
        List<Chamado> chamados = service.findAll();
        return chamados.stream().map(service::toResponse).toList();
    }

    @GetMapping(value = "/{id}")
    public ChamadoResponse findById(@PathVariable Long id) {
        Chamado chamado = service.findById(id);
        return service.toResponse(chamado);
    }

    @Transactional
    @PostMapping
    public ChamadoResponse save(@RequestBody ChamadoRequest chamado) {
        if (Objects.isNull(chamado)) return null;
        Chamado save = service.save(service.toEntity(chamado));
        return service.toResponse(save);
    }

}
