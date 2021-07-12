package br.com.votacao.assembleia.service;

import br.com.votacao.assembleia.modelo.Associado;

import br.com.votacao.assembleia.repository.AssociadoRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class AssociadoService {

    private final AssociadoRepository associadoRepository;

    public AssociadoService(AssociadoRepository associadoRepository){
        this.associadoRepository = associadoRepository;
    }

    public Associado createAssociado(Associado associado){
        boolean exists = associadoRepository.existsByCpf(associado.getCpf());
        if (exists) {
            throw new DuplicateKeyException("Associado duplicado. CPF=" + associado.getCpf());
        }
        associado.setStatus(Associado.Status.ABLE_TO_VOTE);
        return associadoRepository.save(associado);
    }
}
