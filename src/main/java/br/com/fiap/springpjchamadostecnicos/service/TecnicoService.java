package br.com.fiap.springpjchamadostecnicos.service;

import br.com.fiap.springpjchamadostecnicos.dto.response.TecnicoResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TecnicoService {

    @Autowired
    EspecialidadeService especialidadeService;

    public TecnicoResponse toResponse(Tecnico t){
      return   new TecnicoResponse(t.getId(), t.getNome(), especialidadeService.toResponse(t.getEspecialidades()));
    }
}
