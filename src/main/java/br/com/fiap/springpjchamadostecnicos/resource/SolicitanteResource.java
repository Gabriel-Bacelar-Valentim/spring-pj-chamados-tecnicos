package br.com.fiap.springpjchamadostecnicos.resource;


import br.com.fiap.springpjchamadostecnicos.dto.request.EnderecoRequest;
import br.com.fiap.springpjchamadostecnicos.dto.request.SolicitanteRequest;
import br.com.fiap.springpjchamadostecnicos.dto.request.TelefoneRequest;
import br.com.fiap.springpjchamadostecnicos.dto.response.EnderecoResponse;
import br.com.fiap.springpjchamadostecnicos.dto.response.SolicitanteResponse;
import br.com.fiap.springpjchamadostecnicos.dto.response.TelefoneResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Endereco;
import br.com.fiap.springpjchamadostecnicos.entity.Solicitante;
import br.com.fiap.springpjchamadostecnicos.entity.Telefone;
import br.com.fiap.springpjchamadostecnicos.repository.EnderecoRepository;
import br.com.fiap.springpjchamadostecnicos.repository.SolicitanteRepository;
import br.com.fiap.springpjchamadostecnicos.repository.TelefoneRepository;
import br.com.fiap.springpjchamadostecnicos.service.EnderecoService;
import br.com.fiap.springpjchamadostecnicos.service.SolicitanteService;
import br.com.fiap.springpjchamadostecnicos.service.TelefoneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/solicitante")
public class SolicitanteResource {

    @Autowired
    private SolicitanteService service;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private TelefoneService telefoneService;

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
    public ResponseEntity<SolicitanteResponse> save(@RequestBody @Valid SolicitanteRequest solicitante) {
        var entity = service.toEntity(solicitante);
        var salvo = service.save(entity);
        var response = service.toResponse(salvo);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(uri).body(response);

    }


    @Transactional
    @PostMapping(value = "/{id}/telefone")
    public ResponseEntity<TelefoneResponse> save(
            @PathVariable Long id,
            @RequestBody @Valid TelefoneRequest telefone) {

        Solicitante solicitante = service.findById(id);

        if (Objects.isNull(telefone)) return ResponseEntity.badRequest().build();

        var entity = telefoneService.toEntity(telefone);

        entity.setSolicitante(solicitante);

        Telefone saved = telefoneService.save(entity);
        var response = telefoneService.toResponse(saved);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }


    @Transactional
    @PostMapping(value = "/{id}/endereco")
    public ResponseEntity<EnderecoResponse> save(@PathVariable Long id, @RequestBody @Valid EnderecoRequest endereco) {

        var solicitante = service.findById(id);

        if (Objects.isNull(endereco)) return ResponseEntity.badRequest().build();

        var entity = enderecoService.toEntity(endereco);

        entity.setSolicitante(solicitante);

        var saved = enderecoService.save(entity);
        var response = enderecoService.toResponse(saved);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping(value = "/{id}/endereco")
    public ResponseEntity<Collection<EnderecoResponse>> findEnderecoBySolicitante(@PathVariable Long id) {
        var endereco = enderecoService.findBySolicitanteId(id);
        var response = enderecoService.toResponse(endereco);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}/telefone")
    public ResponseEntity<Collection<TelefoneResponse>> findTelefoneBySolicitante(@PathVariable Long id) {
        var telefone = telefoneService.findBySolicitanteId(id);
        var response = telefoneService.toResponse(telefone);
        return ResponseEntity.ok(response);
    }

}
