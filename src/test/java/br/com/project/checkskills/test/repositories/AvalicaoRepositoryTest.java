package br.com.project.checkskills.test.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;
import br.com.project.checkskills.entities.dadosbasicos.EscalaEntity;
import br.com.project.checkskills.entities.matriz.AvaliacaoCompetenciaEntity;
import br.com.project.checkskills.entities.matriz.AvaliacaoEntity;
import br.com.project.checkskills.repositories.dadosbasicos.ICompetenciaRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IEscalaRepository;
import br.com.project.checkskills.repositories.matriz.IAvaliacaoCompetenciaRepository;
import br.com.project.checkskills.repositories.matriz.IAvaliacaoRepository;
import br.com.project.checkskills.test.utils.AbstractDatabaseTest;

public class AvalicaoRepositoryTest  extends AbstractDatabaseTest{

	
	private static final Logger LOGGER = Logger.getLogger(AvalicaoRepositoryTest.class);
	
	@Inject
	private ICompetenciaRepository competenciaRepository;
	
	@Inject
	private IEscalaRepository escalaRepository;
	
	@Inject
	private IAvaliacaoCompetenciaRepository avaliacaoCompetenciaRepository;
	
	@Inject
	private IAvaliacaoRepository avaliacaoRepository;
	
	
	@Test
	public void AvaliacaoCompetenciaTest(){
		CompetenciaEntity competencia = this.competenciaRepository.findOne(1L);
		EscalaEntity escala = this.escalaRepository.findOne(1L);
		
		AvaliacaoCompetenciaEntity  avaliacaoCompetencia =  new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity  avaliacaoCompetencia1 =  new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity  avaliacaoCompetencia2 =  new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity  avaliacaoCompetencia3 =  new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity  avaliacaoCompetencia4 =  new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity  avaliacaoCompetencia5 =  new AvaliacaoCompetenciaEntity(competencia, escala);
		
		List<AvaliacaoCompetenciaEntity> list = new ArrayList<>();
		
		list.add(avaliacaoCompetencia);
		list.add(avaliacaoCompetencia1);
		list.add(avaliacaoCompetencia2);
		list.add(avaliacaoCompetencia3);
		list.add(avaliacaoCompetencia4);
		list.add(avaliacaoCompetencia5);
		
		AvaliacaoEntity avaliacao = new AvaliacaoEntity();
		avaliacao.setAvaliacaoCompetencias(list);
		
		 this.avaliacaoRepository.save(avaliacao);

		LOGGER.info(avaliacao);
	}
	
}
