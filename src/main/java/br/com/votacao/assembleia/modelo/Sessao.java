package br.com.votacao.assembleia.modelo;

import javax.persistence.*;

import java.time.Instant;

@Entity
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant dataInicial;
    private Instant dataFinal;

    public Sessao() {
    }

    public Sessao(Pauta pauta) {
        this.dataInicial = pauta.getDataCriacao();
        setDataFinal(pauta.getDataCriacao());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Instant dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Instant getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Instant dataInicial) {
        this.dataFinal = dataInicial.plusSeconds(60L);
    }
}
