package br.com.project.checkskills.test.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import br.com.project.checkskills.entities.dadosbasicos.DepartamentoEntity;
import br.com.project.checkskills.entities.dadosbasicos.OrganizacaoEntity;
import br.com.project.checkskills.repositories.dadosbasicos.IDepartamentoRepository;
import br.com.project.checkskills.test.utils.AbstractDatabaseTest;

public class DepartamentoRepositoryTest  extends AbstractDatabaseTest{
	
	private static final Logger LOGGER = Logger.getLogger(DepartamentoRepositoryTest.class);
	
	@Inject
	private IDepartamentoRepository departamentoRepository; 
	
	@Test
	public void findAllTest(){
		List<DepartamentoEntity> departamentos = this.departamentoRepository.findAll();
		LOGGER.info(departamentos);
	}

	@Test
	public void saveTest(){
		OrganizacaoEntity organizacao = new OrganizacaoEntity();
		organizacao.setId(1L);
		
		DepartamentoEntity departamento = new DepartamentoEntity();
		departamento.setNomeDepartamento("Planejamento distribuição");
		departamento.setOrganizacao(organizacao);
		departamento.setDepartamentoPai(null);
		
		
		this.departamentoRepository.save(departamento);
		
		LOGGER.info(departamento);
		
	}
}
