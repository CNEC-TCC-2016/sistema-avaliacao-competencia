package br.com.project.checkskills.repositories.dadosbasicos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;

@Repository(value="competenciaRepository")
public interface ICompetenciaRepository extends JpaRepository<CompetenciaEntity, Long>{

	public List<CompetenciaEntity> findByNome(String nome);
	
}
