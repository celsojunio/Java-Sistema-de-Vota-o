package br.com.votacao.assembleia.modelo;

import javax.persistence.*;

@Entity
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ABLE_TO_VOTE;

    public enum Status {
        ABLE_TO_VOTE,
        UNABLE_TO_VOTE;
    }

    public Associado() {
    }

    public Associado(String cpf){
        this.cpf = cpf;
    }

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

    @Override
    public String toString() {
        return "Associado{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", status=" + status +
                '}';
    }
}
