package br.com.votacao.assembleia.converter;

import br.com.votacao.assembleia.controller.form.PautaForm;
import br.com.votacao.assembleia.modelo.Pauta;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PautaConverter implements Converter<PautaForm, Pauta> {
    @Override
    public Pauta convert(PautaForm pautaForm) {
        Pauta pauta = new Pauta();
        pauta.setAtiva(pautaForm.isAtiva());
        pauta.setAssunto(pautaForm.getAssunto());
        pauta.setDataCriacao(pautaForm.getDataCriacao());
        return pauta;
    }
}
