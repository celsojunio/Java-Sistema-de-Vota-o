package br.com.votacao.assembleia.repository;

import br.com.votacao.assembleia.modelo.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
    Associado findByCpf(String cpf);
    boolean existsByCpf(String cpf);
}
