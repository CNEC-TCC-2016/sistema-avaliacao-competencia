package br.com.project.checkskills.repositories.avaliacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.checkskills.entities.dadosbasicos.CargoCompetenciaEntity;

@Repository(value="cargoCompetenciaRepository")
public interface ICargoCompetenciaRepository extends JpaRepository<CargoCompetenciaEntity, Long> {

	
}
