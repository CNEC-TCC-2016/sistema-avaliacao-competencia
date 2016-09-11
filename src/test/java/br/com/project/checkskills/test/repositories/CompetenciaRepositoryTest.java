package br.com.project.checkskills.test.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;
import br.com.project.checkskills.repositories.dadosbasicos.ICompetenciaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public class CompetenciaRepositoryTest {
	
	private static final Logger LOGGER = Logger.getLogger(CompetenciaRepositoryTest.class);
	
	@Inject
	private ICompetenciaRepository competenciaRepository; 
	
	@Test
	public void findAllTest(){
		
		List<CompetenciaEntity> competencias =this.competenciaRepository.findByNome("Liderança");
		
		LOGGER.info(competencias);
	}

	@Ignore
	@Test
	public void delete(){
		CompetenciaEntity competenciaEntity = new CompetenciaEntity();
		competenciaEntity.setId(1L);
		this.competenciaRepository.delete(competenciaEntity);
		LOGGER.info(competenciaEntity);
	}
}
