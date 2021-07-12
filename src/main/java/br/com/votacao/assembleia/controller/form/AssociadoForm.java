package br.com.votacao.assembleia.controller.form;

import br.com.votacao.assembleia.modelo.Associado;
import br.com.votacao.assembleia.modelo.Associado.Status;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AssociadoForm {

    private Long id;
    @NotNull
    @NotEmpty
    @Size(min = 11, max = 11)
    private String cpf;
    private Status status = Associado.Status.ABLE_TO_VOTE;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
