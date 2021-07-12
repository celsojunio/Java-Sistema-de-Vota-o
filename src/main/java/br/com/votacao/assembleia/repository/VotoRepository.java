package br.com.votacao.assembleia.repository;

import br.com.votacao.assembleia.modelo.Associado;
import br.com.votacao.assembleia.modelo.Pauta;
import br.com.votacao.assembleia.modelo.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {
    boolean existsByAssociadoAndPauta(Associado associado, Pauta pauta);
}
