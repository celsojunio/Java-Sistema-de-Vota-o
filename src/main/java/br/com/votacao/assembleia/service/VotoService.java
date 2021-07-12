package br.com.votacao.assembleia.service;

import br.com.votacao.assembleia.modelo.Associado;
import br.com.votacao.assembleia.modelo.Pauta;
import br.com.votacao.assembleia.modelo.Voto;
import br.com.votacao.assembleia.repository.PautaRepository;
import br.com.votacao.assembleia.repository.VotoRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    private final PautaRepository pautaRepository;
    private final VotoRepository votoRepository;

    public VotoService(PautaRepository pautaRepository, VotoRepository votoRepository){
        this.pautaRepository = pautaRepository;
        this.votoRepository = votoRepository;
    }

    public Voto createVoto(Voto voto){
        validateVoto(voto);
        Pauta pauta = voto.getPauta();
        pauta.qtdVoto(voto.getStatus());
        pautaRepository.save(pauta);
        return votoRepository.save(voto);
    }

    protected void validateVoto(Voto voto) {
        validateExists(voto);
        validatePauta(voto);
    }

    protected void validateExists(Voto voto) {
        Pauta pauta = voto.getPauta();
        Associado associado = voto.getAssociado();
        boolean exists = votoRepository.existsByAssociadoAndPauta(associado, pauta);
        if (exists) {
            throw new DuplicateKeyException("Voto duplicado. CPF=" +
                    associado.getCpf() + ", PAUTA=" + pauta.getAssunto());
        }
    }

    protected void validatePauta(Voto voto) {
        Pauta pauta = voto.getPauta();
        if (!pauta.isAtiva()) {
            throw new DuplicateKeyException("Pauta inativa. PAUTA=" + pauta.getAssunto());
        }
    }

}
