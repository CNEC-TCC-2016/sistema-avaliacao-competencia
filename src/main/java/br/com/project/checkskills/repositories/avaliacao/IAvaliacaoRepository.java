package br.com.project.checkskills.repositories.avaliacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.checkskills.entities.avaliacao.AvaliacaoEntity;

@Repository(value="avaliacaoRepository")
public interface IAvalicaoRepository extends JpaRepository<AvaliacaoEntity, Long> {

}
