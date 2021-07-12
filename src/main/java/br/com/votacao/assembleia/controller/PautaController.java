package br.com.votacao.assembleia.controller;

import br.com.votacao.assembleia.controller.form.PautaForm;
import br.com.votacao.assembleia.converter.PautaConverter;
import br.com.votacao.assembleia.modelo.Pauta;
import br.com.votacao.assembleia.modelo.Sessao;
import br.com.votacao.assembleia.repository.PautaRepository;
import br.com.votacao.assembleia.repository.SessaoRepository;
import br.com.votacao.assembleia.service.SessaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pauta")
public class PautaController {

    private final PautaRepository pautaRepository;
    private final SessaoRepository sessaoRepository;
    private final SessaoService sessaoService;
    private final PautaConverter pautaConverter;

    public PautaController(PautaRepository pautaRepository, SessaoRepository sessaoRepository,
                           SessaoService sessaoService, PautaConverter pautaConverter){
        this.pautaRepository = pautaRepository;
        this.sessaoRepository = sessaoRepository;
        this.sessaoService = sessaoService;
        this.pautaConverter = pautaConverter;
    }

    @GetMapping
    public List<Pauta> getAllPauta(){
        return pautaRepository.findAll();
    }

    @PostMapping//para resultar em 201 tenho que usar a class ResponseEntity
    public Pauta createPauta(@RequestBody PautaForm pautaForm) {
        Pauta pauta = pautaConverter.convert(pautaForm);
        Sessao sessao = sessaoService.abrirSessao(pauta);
        sessaoRepository.save(sessao);
        pauta.setSessao(sessao);
        return pautaRepository.save(pauta);

//        Pauta pauta = PautaForm.converter(form);
//        Sessao sessao = sessaoService.abrirSessao(pauta);
//        sessaoRepository.save(sessao);
//        pauta.setSessao(sessao);
//        pautaRepository.save(pauta);
//        URI uri = uriBuilder.path("/pauta/{id}").buildAndExpand(pauta.getId()).toUri();
//        return ResponseEntity.created(uri).body(new PautaDto(pauta));
    }

    @GetMapping("/{id}")
    public Pauta getPautaById(@PathVariable Long id){
        return pautaRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deletePauta(@PathVariable Long id){
        sessaoRepository.deleteById(id);
        pautaRepository.deleteById(id);
    }
}
