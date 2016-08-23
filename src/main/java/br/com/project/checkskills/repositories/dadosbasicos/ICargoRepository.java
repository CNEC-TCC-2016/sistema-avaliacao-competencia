package br.com.project.checkskills.repositories.dadosbasicos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.checkskills.entities.dadosbasicos.CargoEntity;

@Repository(value="cargoRepository")
public interface ICargoRepository extends JpaRepository<CargoEntity, Long> {
	
	public List<CargoEntity> findByNomeCargo(String nomeCargo);
}
