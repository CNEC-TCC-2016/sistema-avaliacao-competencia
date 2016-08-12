package br.com.project.checkskills.repositories.dadosbasicos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;

public interface ICompetenciaRepository extends JpaRepository<CompetenciaEntity, Long>{

	public List<CompetenciaEntity> findByNome(String nome);
	
}
