package br.com.project.checkskills.test.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.project.checkskills.entities.avaliacao.CicloAvaliacaoEntity;
import br.com.project.checkskills.repositories.avaliacao.ICicloAvaliacaoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-test.xml" })
public class CicloAvaliacaoRepositoryTest{
	
	private static final Logger LOGGER = Logger.getLogger(CicloAvaliacaoRepositoryTest.class);
	
	@Inject
	private ICicloAvaliacaoRepository cicloAvaliacaoRepository;
	
	@Test
	public void findAllTest(){
		List<CicloAvaliacaoEntity> ciclo = this.cicloAvaliacaoRepository.findAll();
		LOGGER.info(ciclo);
	}
}
