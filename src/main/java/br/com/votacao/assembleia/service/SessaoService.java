package br.com.votacao.assembleia.service;

import br.com.votacao.assembleia.modelo.Pauta;
import br.com.votacao.assembleia.modelo.Sessao;
import br.com.votacao.assembleia.repository.SessaoRepository;
import org.springframework.stereotype.Service;

@Service
public class SessaoService{

    private final SessaoRepository sessaoRepository;

    public SessaoService(SessaoRepository sessaoRepository){
        this.sessaoRepository = sessaoRepository;
    }

    public Sessao abrirSessao(Pauta pauta){
        Sessao sessao = new Sessao(pauta);
        return sessaoRepository.save(sessao);
    }
}
