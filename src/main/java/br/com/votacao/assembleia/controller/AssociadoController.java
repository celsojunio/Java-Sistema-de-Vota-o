package br.com.votacao.assembleia.controller;

import br.com.votacao.assembleia.controller.form.AssociadoForm;
import br.com.votacao.assembleia.converter.AssociadoConverter;
import br.com.votacao.assembleia.modelo.Associado;
import br.com.votacao.assembleia.repository.AssociadoRepository;
import br.com.votacao.assembleia.repository.PautaRepository;
import br.com.votacao.assembleia.service.AssociadoService;
import br.com.votacao.assembleia.service.SessaoService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/associado")
public class AssociadoController {

    private final AssociadoRepository associadoRepository;
    private final AssociadoConverter associadoConverter;
    private final PautaRepository pautaRepository;
    private final AssociadoService associadoService;

    public AssociadoController(AssociadoRepository associadoRepository,
                               PautaRepository pautaRepository, AssociadoService associadoService, AssociadoConverter associadoConverter) {
        this.associadoRepository = associadoRepository;
        this.pautaRepository = pautaRepository;
        this.associadoService = associadoService;
        this.associadoConverter = associadoConverter;
    }

    @GetMapping
    public List<Associado> getAllAssociados() {
        return associadoRepository.findAll();
    }

    @PostMapping
    @Transactional
    public Associado createAssociado(@RequestBody @Valid AssociadoForm associadoForm){
        Associado associado = associadoConverter.convert(associadoForm);
        return associadoService.createAssociado(associado);
    }

    @GetMapping("/{id}")
    public Associado getAssociadoById(@PathVariable Long id){
        return associadoRepository.findById(id).get();
    }

    @GetMapping("/{cpf}")
    public Associado getAssociadoByCpf(@PathVariable Associado associado){
        Associado associadoCadastrado = associadoRepository.findByCpf(associado.getCpf());
        if (associadoCadastrado != null){
            return associadoCadastrado;
        } else {
            throw new NullPointerException();
        }

    }
}
