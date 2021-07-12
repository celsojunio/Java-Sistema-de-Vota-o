package br.com.votacao.assembleia.controller.dto;

import br.com.votacao.assembleia.modelo.Pauta;

import java.time.Instant;

public class PautaDto {

    private long id;
    private String assunto;
    private Instant dataCriacao;
    private boolean ativa;

    public PautaDto(){
    }

    public PautaDto(Pauta pauta){
        this.id = pauta.getId();
        this.assunto = pauta.getAssunto();
        this.dataCriacao= pauta.getDataCriacao();
        this.ativa = pauta.isAtiva();
    }

    public long getId() {
        return id;
    }

    public String getAssunto() {
        return assunto;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public boolean isAtiva() {
        return ativa;
    }
}
