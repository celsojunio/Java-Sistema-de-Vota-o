package br.com.votacao.assembleia.service;

import br.com.votacao.assembleia.modelo.Pauta;
import br.com.votacao.assembleia.repository.PautaRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PautaService {

    private final PautaRepository pautaRepository;

    public PautaService(PautaRepository pautaRepository){
        this.pautaRepository = pautaRepository;
    }

    @Scheduled(fixedRate = 5000)
    public void fecharPauta(){
        List<Pauta> pautas = pautaRepository.findAll();
        pautas.forEach(pauta-> {
            pauta.verificar(pauta);
            pautaRepository.save(pauta);
        });
    }
}
