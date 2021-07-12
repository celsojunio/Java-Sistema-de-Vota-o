package br.com.votacao.assembleia.converter;

import br.com.votacao.assembleia.controller.form.VotoForm;
import br.com.votacao.assembleia.modelo.Associado;
import br.com.votacao.assembleia.modelo.Pauta;
import br.com.votacao.assembleia.modelo.Voto;
import br.com.votacao.assembleia.repository.AssociadoRepository;
import br.com.votacao.assembleia.repository.PautaRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VotoConverter implements Converter<VotoForm, Voto> {
    private PautaRepository pautaRepository;
    private AssociadoRepository associadoRepository;


    public VotoConverter(PautaRepository pautaRepository,AssociadoRepository associadoRepository){
        this.pautaRepository = pautaRepository;
        this.associadoRepository = associadoRepository;
    }

    @Override
    public Voto convert(VotoForm votoForm) {
        Voto voto = new Voto();
        Pauta pauta = pautaRepository.findById(votoForm.getPautaId()).get();
        Associado associado = associadoRepository.findById(votoForm.getAssociadoId()).get();
        voto.setAssociado(associado);
        voto.setPauta(pauta);
        voto.setStatus(votoForm.getStatus());
        return voto;
    }
}
