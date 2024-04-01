package br.com.fiap.springpjchamadostecnicos.service;


import br.com.fiap.springpjchamadostecnicos.dto.response.SolicitanteResponse;
import br.com.fiap.springpjchamadostecnicos.entity.Solicitante;
import br.com.fiap.springpjchamadostecnicos.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitanteService {


    @Autowired
    SolicitanteRepository repo;

    public SolicitanteResponse toResponse(Solicitante s) {
        return new SolicitanteResponse(s.getId(), s.getNome());
    }

    public Solicitante findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
