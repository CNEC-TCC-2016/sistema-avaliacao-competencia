package br.com.project.checkskills.test.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.project.checkskills.entities.avaliacao.AvaliacaoCompetenciaEntity;
import br.com.project.checkskills.entities.avaliacao.AvaliacaoEntity;
import br.com.project.checkskills.entities.avaliacao.MatrizEntity;
import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;
import br.com.project.checkskills.entities.dadosbasicos.EscalaEntity;
import br.com.project.checkskills.entities.dadosbasicos.FuncionarioEntity;
import br.com.project.checkskills.repositories.avaliacao.IAvalicaoRepository;
import br.com.project.checkskills.repositories.dadosbasicos.ICompetenciaRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IEscalaRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IFuncionarioRepository;
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
	
	@Inject
	private IFuncionarioRepository funcionarioRepository;
	
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
		
		
		
		FuncionarioEntity avaliado = new FuncionarioEntity();
		avaliado = this.funcionarioRepository.findOne(1L);
		
		FuncionarioEntity lider = new FuncionarioEntity();
		lider = this.funcionarioRepository.findOne(2L);
		
		
		List<FuncionarioEntity>  funcionarios = new ArrayList<>();
		funcionarios.add(avaliado);
		funcionarios.add(lider);
		
		AvaliacaoEntity entity = new AvaliacaoEntity();
		entity.setAvaliacaoCompetencias(avaliacaoCompetencia);
	
		MatrizEntity matrizEntity = new MatrizEntity();
	
		
		entity.setFuncionarios(funcionarios);
		entity.setMatriz(matrizEntity);
		
		this.avalicaoRepository.save(entity);
		
		LOGGER.info(entity);
		
		
		
	}
	
}
