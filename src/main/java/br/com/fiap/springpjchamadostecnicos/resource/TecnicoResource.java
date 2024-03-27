package br.com.fiap.springpjchamadostecnicos.resource;

import br.com.fiap.springpjchamadostecnicos.entity.Especialidade;
import br.com.fiap.springpjchamadostecnicos.entity.Tecnico;
import br.com.fiap.springpjchamadostecnicos.repository.EspecialidadeRepository;
import br.com.fiap.springpjchamadostecnicos.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/tecnico")
public class TecnicoResource {
    @Autowired
    private TecnicoRepository repo;
    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @GetMapping
    public List<Tecnico> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Tecnico findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Tecnico save(@RequestBody Tecnico tecnico) {

        if (Objects.isNull(tecnico)) return null;
        tecnico.setId(null);
        tecnico.setEspecialidades(null);
        return repo.save(tecnico);
    }


    @Transactional
    @PostMapping(value = "/{id}/especialidade")
    public Tecnico save(@PathVariable Long id, @RequestBody Especialidade especialidade) {

        if (Objects.isNull(especialidade)) return null;

        Tecnico tecnico = repo.findById(id).orElseThrow();

        if (Objects.nonNull(especialidade.getId())) {
            especialidade = especialidadeRepository.findById(especialidade.getId()).orElseThrow();
        }
        tecnico.getEspecialidades().add(especialidade);
        return tecnico;

    }

}
