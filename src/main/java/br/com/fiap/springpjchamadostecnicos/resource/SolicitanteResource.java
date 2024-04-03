package br.com.fiap.springpjchamadostecnicos.resource;


import br.com.fiap.springpjchamadostecnicos.dto.request.SolicitanteRequest;
import br.com.fiap.springpjchamadostecnicos.dto.response.SolicitanteResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Endereco;
import br.com.fiap.springpjchamadostecnicos.entity.Solicitante;
import br.com.fiap.springpjchamadostecnicos.entity.Telefone;
import br.com.fiap.springpjchamadostecnicos.repository.EnderecoRepository;
import br.com.fiap.springpjchamadostecnicos.repository.SolicitanteRepository;
import br.com.fiap.springpjchamadostecnicos.repository.TelefoneRepository;
import br.com.fiap.springpjchamadostecnicos.service.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/solicitante")
public class SolicitanteResource {

    @Autowired
    private SolicitanteService service;


    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @GetMapping
    public List<SolicitanteResponse> findAll() {
        return service.findAll().stream().map(service::toResponse).toList();
    }

    @GetMapping(value = "/{id}")
    public SolicitanteResponse findById(@PathVariable Long id) {
        return service.toResponse(service.findById(id));
    }

    @Transactional
    @PostMapping
    public SolicitanteResponse save(@RequestBody SolicitanteRequest solicitante) {
        var entity = service.toEntity(solicitante);
        var salvo = service.save(entity);
        return service.toResponse(salvo);
    }


    @Transactional
    @PostMapping(value = "/{id}/telefone")
    public Telefone save(@PathVariable Long id, @RequestBody Telefone telefone) {
        Solicitante solicitante = service.findById(id);
        if (Objects.isNull(telefone)) return null;
        telefone.setSolicitante(solicitante);
        return telefoneRepository.save(telefone);
    }


    @Transactional
    @PostMapping(value = "/{id}/endereco")
    public Endereco save(@PathVariable Long id, @RequestBody Endereco endereco) {
        Solicitante solicitante = service.findById(id);
        if (Objects.isNull(endereco)) return null;
        endereco.setSolicitante(solicitante);
        return enderecoRepository.save(endereco);
    }

    @GetMapping(value = "/{id}/endereco")
    public List<Endereco> findEnderecoBySolicitante(@PathVariable Long id) {
        return enderecoRepository.findBySolicitanteId(id);
    }

    @GetMapping(value = "/{id}/telefone")
    public List<Telefone> findTelefoneBySolicitante(@PathVariable Long id) {
        return telefoneRepository.findBySolicitanteId(id);
    }

}
