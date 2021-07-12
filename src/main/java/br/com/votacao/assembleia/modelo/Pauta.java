package br.com.votacao.assembleia.modelo;

import br.com.votacao.assembleia.controller.form.PautaForm;
import br.com.votacao.assembleia.modelo.Voto.SimNao;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Pauta implements Comparable<Pauta>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String assunto;
    private Instant dataCriacao = Instant.now();
    private Integer qtdPositivo = 0;
    private Integer qtdNegativo = 0;
    private boolean ativa;
    @OneToOne
    private Sessao sessao;


    public Pauta(){
    }

    public Pauta(PautaForm form){
        this.id= form.getId();
        this.assunto = form.getAssunto();
    }

    public void qtdVoto(SimNao status){
        if(status != null) {
            if (status.equals(status.SIM)) {
                setQtdPositivo(1);
            } else if (status.equals(status.NAO)) {
                setQtdNegativo(1);
            }
        }
    }

    public String getResultadoVotacao(){
        if(ativa){
            return "Votação em andamento!";
        }
        if(this.getQtdPositivo() > this.getQtdNegativo()){
            return "A Votacão foi APROVADA! Com o total de "+ this.getQtdPositivo()+" votos a favor!";
        }else if(this.getQtdNegativo() > this.getQtdPositivo()) {
            return "A Votacão foi REPROVADA! Com o total de " + this.getQtdNegativo() + " votos contra!";
        }else{
            return "A votação deu EMPATE!";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getQtdPositivo() {
        return qtdPositivo;
    }

    public void setQtdPositivo(Integer qtdPositivo) {
        this.qtdPositivo += qtdPositivo;
    }

    public Integer getQtdNegativo() {
        return qtdNegativo;
    }

    public void setQtdNegativo(Integer qtdNegativo) {
        this.qtdNegativo += qtdNegativo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
    public void verificar(Pauta pauta){
        if (pauta.isAtiva()){
            pauta.compareTo(pauta);
        }
    }

    @Override
    public int compareTo(Pauta pauta) {
        long timePauta = pauta.sessao.getDataFinal().getEpochSecond();
        long agora = Instant.now().getEpochSecond();
        if (timePauta <= agora) {
            pauta.setAtiva(false);
            System.out.println("falso");
            return 0;
        }else{
            System.out.println("ainda true");
            return 1;
        }
    }

}
