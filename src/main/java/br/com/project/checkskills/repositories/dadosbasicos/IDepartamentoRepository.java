package br.com.project.checkskills.repositories.dadosbasicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.checkskills.entities.dadosbasicos.DepartamentoEntity;

@Repository(value="departamentoRepository")
public interface IDepartamentoRepository extends JpaRepository<DepartamentoEntity, Long> {

	
	
	
}
