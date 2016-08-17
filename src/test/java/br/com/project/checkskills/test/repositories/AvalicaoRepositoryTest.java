package br.com.project.checkskills.test.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.project.checkskills.entities.avaliacao.AvaliacaoCompetenciaEntity;
import br.com.project.checkskills.entities.avaliacao.AvaliacaoEntity;
import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;
import br.com.project.checkskills.entities.dadosbasicos.EscalaEntity;
import br.com.project.checkskills.repositories.avaliacao.IAvalicaoRepository;
import br.com.project.checkskills.repositories.dadosbasicos.ICompetenciaRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IEscalaRepository;
import br.com.project.checkskills.test.utils.AbstractDatabaseTest;

public class AvalicaoRepositoryTest extends AbstractDatabaseTest{

	
	private static final Logger LOGGER = Logger
			.getLogger(AvalicaoRepositoryTest.class);
	
	@Inject
	private IAvalicaoRepository avalicaoRepository;
	
	@Inject
	private ICompetenciaRepository competenciaRepository;
	
	@Inject
	private IEscalaRepository escalaRepository;
	
	@Test
	public void saveAvaliacaoTest(){

		CompetenciaEntity competencia = this.competenciaRepository.findOne(2L);
		
		EscalaEntity escala = this.escalaRepository.findOne(1L);
		
		AvaliacaoCompetenciaEntity a1 = new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity a2 = new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity a3 = new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity a4 = new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity a5 = new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity a6 = new AvaliacaoCompetenciaEntity(competencia, escala);
		
		List<AvaliacaoCompetenciaEntity> avaliacaoCompetencia = new ArrayList<>();
		
		avaliacaoCompetencia.add(a1);
		avaliacaoCompetencia.add(a2);
		avaliacaoCompetencia.add(a3);
		avaliacaoCompetencia.add(a4);
		avaliacaoCompetencia.add(a5);
		avaliacaoCompetencia.add(a6);
		
		AvaliacaoEntity entity = new AvaliacaoEntity();
		entity.setAvaliacaoCompetencias(avaliacaoCompetencia);
		
		
		this.avalicaoRepository.save(entity);
		
		LOGGER.info(entity);
		
		
		
	}
	
}
