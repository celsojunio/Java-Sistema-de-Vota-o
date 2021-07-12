package br.com.votacao.assembleia.converter;

import br.com.votacao.assembleia.controller.form.AssociadoForm;
import br.com.votacao.assembleia.modelo.Associado;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AssociadoConverter implements Converter<AssociadoForm, Associado> {
    @Override
    public Associado convert(AssociadoForm associadoForm) {
        Associado associado = new Associado();
        associado.setId(associadoForm.getId());
        associado.setCpf(associadoForm.getCpf());
        return associado;
    }
}
