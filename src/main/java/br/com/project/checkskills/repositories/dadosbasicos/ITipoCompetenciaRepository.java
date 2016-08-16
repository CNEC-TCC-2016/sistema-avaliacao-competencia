package br.com.project.checkskills.repositories.dadosbasicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.checkskills.entities.dadosbasicos.TipoCompetenciaEntity;

@Repository(value="tipoCompetenciaRepository")
public interface ITipoCompetenciaRepository extends JpaRepository<TipoCompetenciaEntity, Long>{

}
