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
import br.com.project.checkskills.entities.matriz.MatrizEntity;
import br.com.project.checkskills.repositories.dadosbasicos.ICompetenciaRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IEscalaRepository;
import br.com.project.checkskills.repositories.matriz.IAvaliacaoCompetenciaRepository;
import br.com.project.checkskills.repositories.matriz.IAvaliacaoRepository;
import br.com.project.checkskills.repositories.matriz.IMatrizRepository;
import br.com.project.checkskills.test.utils.AbstractDatabaseTest;

public class MatrizRepositoryTest  extends AbstractDatabaseTest{

	
	private static final Logger LOGGER = Logger.getLogger(MatrizRepositoryTest.class);
	
	@Inject
	private ICompetenciaRepository competenciaRepository;
	
	@Inject
	private IEscalaRepository escalaRepository;
	
	@Inject
	private IAvaliacaoCompetenciaRepository avaliacaoCompetenciaRepository;
	
	@Inject
	private IAvaliacaoRepository avaliacaoRepository;
	
	@Inject
	private IMatrizRepository matrizRepository;
	

	
	@Test
	public void AvaliacaoCompetenciaTest(){
		
		CompetenciaEntity competencia = this.competenciaRepository.findOne(1L);
		EscalaEntity escala = this.escalaRepository.findOne(1L);
		
		AvaliacaoCompetenciaEntity  avaliacaoC1 =  new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity  avaliacaoC2 =  new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity  avaliacaoC3 =  new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity  avaliacaoC4 =  new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity  avaliacaoC5 =  new AvaliacaoCompetenciaEntity(competencia, escala);
		AvaliacaoCompetenciaEntity  avaliacaoC6 =  new AvaliacaoCompetenciaEntity(competencia, escala);
		
		List<AvaliacaoCompetenciaEntity> list = new ArrayList<>();
		list.add(avaliacaoC1);
		list.add(avaliacaoC2);
		list.add(avaliacaoC3);
		list.add(avaliacaoC4);
		list.add(avaliacaoC5);
		list.add(avaliacaoC6);
		

		MatrizEntity matrizEntity = new MatrizEntity();
		
		AvaliacaoEntity avaliacaoEntity1 = new AvaliacaoEntity();
		avaliacaoEntity1.setAvaliacaoCompetencias(list);
		avaliacaoEntity1.setMatrizEntity(matrizEntity);
		
		AvaliacaoEntity avaliacaoEntity2 = new AvaliacaoEntity();
		avaliacaoEntity2.setAvaliacaoCompetencias(list);
		avaliacaoEntity2.setMatrizEntity(matrizEntity);
		
		AvaliacaoEntity avaliacaoEntity3 = new AvaliacaoEntity();
		avaliacaoEntity3.setAvaliacaoCompetencias(list);
		avaliacaoEntity3.setMatrizEntity(matrizEntity);
		
		List<AvaliacaoEntity> avaliacaoList = new ArrayList<>();
		
		
		
		matrizEntity.setAvaliacoes(avaliacaoList);
		
	
		this.matrizRepository.save(matrizEntity);
		
		LOGGER.info(matrizEntity);
	}
	
}
