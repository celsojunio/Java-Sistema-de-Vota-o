package br.com.votacao.assembleia.repository;

import br.com.votacao.assembleia.modelo.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Long> {

}
