package br.com.project.checkskills.test.repositories;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;
import br.com.project.checkskills.entities.dadosbasicos.EscalaEntity;
import br.com.project.checkskills.entities.matriz.AvaliacaoCompetenciaEntity;
import br.com.project.checkskills.repositories.dadosbasicos.ICompetenciaRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IEscalaRepository;
import br.com.project.checkskills.repositories.matriz.IAvaliacaoCompetenciaRepository;
import br.com.project.checkskills.test.utils.AbstractDatabaseTest;

public class AvaliacaoCompetenciaRepositoryTest  extends AbstractDatabaseTest{

	
	private static final Logger LOGGER = Logger.getLogger(AvaliacaoCompetenciaRepositoryTest.class);
	
	@Inject
	private ICompetenciaRepository competenciaRepository;
	
	@Inject
	private IEscalaRepository escalaRepository;
	
	@Inject
	private IAvaliacaoCompetenciaRepository avaliacaoCompetenciaRepository;
	
	
	@Test
	public void AvaliacaoCompetenciaTest(){
		CompetenciaEntity competencia = this.competenciaRepository.findOne(1L);
		EscalaEntity escala = this.escalaRepository.findOne(1L);
		
		AvaliacaoCompetenciaEntity  avaliacaoCompetencia =  new AvaliacaoCompetenciaEntity(competencia, escala);
		
		this.avaliacaoCompetenciaRepository.save(avaliacaoCompetencia);

		LOGGER.info(avaliacaoCompetencia);
	}
	
}
