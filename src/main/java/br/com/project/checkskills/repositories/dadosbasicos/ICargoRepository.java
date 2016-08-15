package br.com.project.checkskills.repositories.dadosbasicos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.checkskills.entities.dadosbasicos.CargoEntity;

public interface ICargoRepository extends JpaRepository<CargoEntity, Long> {
	
	public List<CargoEntity> findByNomeCargo(String nomeCargo);
}
