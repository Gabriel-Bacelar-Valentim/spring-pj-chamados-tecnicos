package br.com.fiap.springpjchamadostecnicos.resource;


import br.com.fiap.springpjchamadostecnicos.entity.Chamado;
import br.com.fiap.springpjchamadostecnicos.repository.ChamadoRepository;
import br.com.fiap.springpjchamadostecnicos.repository.EspecialidadeRepository;
import br.com.fiap.springpjchamadostecnicos.repository.SolicitanteRepository;
import br.com.fiap.springpjchamadostecnicos.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/chamado")
public class ChamadoResource {

    @Autowired
    private ChamadoRepository repo;
    @Autowired
    private EspecialidadeRepository especialidadeRepository;
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @GetMapping
    public List<Chamado> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Chamado findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }


    @Transactional
    @PostMapping
    public Chamado save(@RequestBody Chamado chamado){

        if(Objects.isNull(chamado)) return null;
        chamado.setId(null);

        if(Objects.nonNull(chamado.getEspecialidade().getId())){
            var especialidade = especialidadeRepository.findById(
                    chamado.getEspecialidade().getId()
            ).orElseThrow();

            chamado.setEspecialidade(especialidade);
        }

        chamado.setTecnico(null);

        if(Objects.nonNull(chamado.getSolicitante().getId())){
            var solicitante = solicitanteRepository.findById(
                    chamado.getSolicitante().getId()
            ).orElseThrow();
            chamado.setSolicitante(solicitante);
        }

        return repo.save(chamado);

    }

}
