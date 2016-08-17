package br.com.project.checkskills.repositories.dadosbasicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.checkskills.entities.dadosbasicos.EscalaEntity;

@Repository(value="escalaRepository")
public interface IEscalaRepository extends JpaRepository<EscalaEntity, Long> {

}
