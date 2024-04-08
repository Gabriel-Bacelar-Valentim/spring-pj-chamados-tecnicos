package br.com.fiap.springpjchamadostecnicos.resource;

import br.com.fiap.springpjchamadostecnicos.entity.Ocorrencia;
import br.com.fiap.springpjchamadostecnicos.entity.Tecnico;
import br.com.fiap.springpjchamadostecnicos.repository.ChamadoRepository;
import br.com.fiap.springpjchamadostecnicos.repository.OcorrenciaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/ocorrencia")
public class OcorrenciaResource {

    @Autowired
    private OcorrenciaRepository repo;

    @Autowired
    ChamadoRepository chamadoRepository;

    @GetMapping
    public List<Ocorrencia> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Ocorrencia findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }


    @PostMapping
    @Transactional
    public Ocorrencia save(@RequestBody  @Valid Ocorrencia ocorrencia) {
        if (Objects.isNull(ocorrencia)) return null;
        ocorrencia.setId(null);
        if (Objects.isNull(ocorrencia.getChamado().getId())) return null;
        var chamado = chamadoRepository.findById(ocorrencia.getChamado().getId()).orElseThrow();
        ocorrencia.setChamado(chamado);
        ocorrencia.setData(LocalDateTime.now());
        return repo.save(ocorrencia);
    }


}
