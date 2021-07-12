package br.com.votacao.assembleia.controller;

import br.com.votacao.assembleia.controller.form.VotoForm;
import br.com.votacao.assembleia.converter.VotoConverter;
import br.com.votacao.assembleia.modelo.Associado;
import br.com.votacao.assembleia.modelo.Pauta;
import br.com.votacao.assembleia.modelo.Voto;
import br.com.votacao.assembleia.repository.AssociadoRepository;
import br.com.votacao.assembleia.repository.PautaRepository;
import br.com.votacao.assembleia.service.VotoService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/voto")
public class VotoController {

    private final PautaRepository pautaRepository;
    private final AssociadoRepository associadoRepository;
    private final VotoService votoService;
    private final VotoConverter votoConverter;


    public VotoController(PautaRepository pautaRepository, AssociadoRepository associadoRepository,
                          VotoService votoService, VotoConverter votoConverter){
        this.pautaRepository = pautaRepository;
        this.associadoRepository = associadoRepository;
        this.votoService = votoService;
        this.votoConverter = votoConverter;
    }

    @PostMapping
    public Voto createVoto(@RequestBody @Valid VotoForm form) {
        Voto voto = votoConverter.convert(form);
        return votoService.createVoto(voto);
    }
}
