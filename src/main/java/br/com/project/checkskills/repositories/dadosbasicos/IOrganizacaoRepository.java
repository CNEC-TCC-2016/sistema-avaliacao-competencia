package br.com.project.checkskills.repositories.dadosbasicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.checkskills.entities.dadosbasicos.OrganizacaoEntity;

@Repository(value="organizacaoRepository")
public interface IOrganizacaoRepository extends JpaRepository<OrganizacaoEntity, Long> {

	
	
	
}
