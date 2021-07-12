package br.com.votacao.assembleia.controller.form;

import br.com.votacao.assembleia.modelo.Voto.SimNao;

import javax.validation.constraints.NotNull;

public class VotoForm {

    private Long id;
    @NotNull
    private Long pautaId;
    @NotNull
    private Long associadoId;
    @NotNull
    private SimNao status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SimNao getStatus() {
        return status;
    }

    public void setStatus(SimNao status) {
        this.status = status;
    }

    public Long getPautaId() {
        return pautaId;
    }

    public void setPautaId(Long pautaId) {
        this.pautaId = pautaId;
    }

    public Long getAssociadoId() {
        return associadoId;
    }

    public void setAssociadoId(Long associadoId) {
        this.associadoId = associadoId;
    }
}
