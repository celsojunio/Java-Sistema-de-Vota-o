package br.com.votacao.assembleia.repository;

import br.com.votacao.assembleia.modelo.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {
}
