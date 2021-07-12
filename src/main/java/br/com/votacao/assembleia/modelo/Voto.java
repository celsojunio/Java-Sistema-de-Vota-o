package br.com.votacao.assembleia.modelo;

import javax.persistence.*;

@Entity
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Pauta pauta;
    @ManyToOne
    private Associado associado;
    private SimNao status;

    public enum SimNao {
        SIM,
        NAO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public SimNao getStatus() {
        return status;
    }

    public void setStatus(SimNao status) {
        this.status = status;
    }
}
