package br.com.votacao.assembleia;

import br.com.votacao.assembleia.modelo.Associado;
import br.com.votacao.assembleia.modelo.Pauta;
import br.com.votacao.assembleia.modelo.Voto;
import br.com.votacao.assembleia.repository.AssociadoRepository;
import br.com.votacao.assembleia.repository.PautaRepository;
import br.com.votacao.assembleia.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;


@SpringBootApplication
@EnableScheduling
public class AssembleiaApplication{

	public static void main(String[] args) {
		SpringApplication.run(AssembleiaApplication.class, args);
	}

	@Autowired
	AssociadoRepository associadoRepository;
	@Autowired
	PautaRepository pautaRepository;
	@Autowired
	VotoRepository votoRepository;

	@PostConstruct
	public void start() {
//		Associado associado = new Associado();
//		associado.setCpf("02276098082");
//		associadoRepository.save(associado);
//
//		Pauta pauta = new Pauta();
//		pauta.setAssunto("Alho");
//		pautaRepository.save(pauta);
//
//		Voto votoA = new Voto();
//		votoA.setAssociado(associado);
//		votoA.setPauta(pauta);
//		votoA.setStatus(Voto.SimNao.NAO);
//
//		Voto votoB = new Voto();
//		votoB.setAssociado(associado);
//		votoB.setPauta(pauta);
//		votoB.setStatus(Voto.SimNao.SIM);
//
//		votoRepository.save(votoA);
//		votoRepository.save(votoB);
	}

}
