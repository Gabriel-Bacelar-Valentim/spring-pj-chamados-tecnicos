package br.com.fiap.springpjchamadostecnicos.resource;


import br.com.fiap.springpjchamadostecnicos.entity.Endereco;
import br.com.fiap.springpjchamadostecnicos.entity.Solicitante;
import br.com.fiap.springpjchamadostecnicos.entity.Telefone;
import br.com.fiap.springpjchamadostecnicos.repository.EnderecoRepository;
import br.com.fiap.springpjchamadostecnicos.repository.SolicitanteRepository;
import br.com.fiap.springpjchamadostecnicos.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/solicitante")
public class SolicitanteResource {

    @Autowired
    private SolicitanteRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @GetMapping
    public List<Solicitante> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Solicitante findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Solicitante save(@RequestBody Solicitante solicitante) {
        solicitante.setId(null);
        return repo.save(solicitante);
    }


    @Transactional
    @PostMapping(value = "/{id}/telefone")
    public Telefone save(@PathVariable Long id, @RequestBody Telefone telefone) {
        Solicitante solicitante = repo.findById(id).orElseThrow();
        if (Objects.isNull(telefone)) return null;
        telefone.setSolicitante(solicitante);
        return telefoneRepository.save(telefone);
    }


    @Transactional
    @PostMapping(value = "/{id}/endereco")
    public Endereco save(@PathVariable Long id, @RequestBody Endereco endereco) {
        Solicitante solicitante = repo.findById(id).orElseThrow();
        if (Objects.isNull(endereco)) return null;
        endereco.setSolicitante(solicitante);
        return enderecoRepository.save(endereco);
    }

    @GetMapping(value = "/{id}/endereco")
    public List<Endereco> findEnderecoBySolicitante(@PathVariable Long id){
       return enderecoRepository.findBySolicitanteId(id);
    }


    @GetMapping(value = "/{id}/telefone")
    public List<Telefone> findTelefoneBySolicitante(@PathVariable Long id){
        return telefoneRepository.findBySolicitanteId(id);
    }

}
