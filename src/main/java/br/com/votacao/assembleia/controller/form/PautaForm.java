package br.com.votacao.assembleia.controller.form;

import br.com.votacao.assembleia.controller.dto.PautaDto;
import br.com.votacao.assembleia.modelo.Pauta;
import com.sun.istack.NotNull;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotEmpty;

public class PautaForm{

    private Long id;
    @NotNull @NotEmpty
    private String assunto;
    private Instant dataCriacao = Instant.now();
    private boolean ativa = true;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
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
