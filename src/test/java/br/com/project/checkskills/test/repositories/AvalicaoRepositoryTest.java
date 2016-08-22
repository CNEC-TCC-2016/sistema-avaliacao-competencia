package br.com.project.checkskills.test.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.project.checkskills.entities.avaliacao.AvaliacaoCompetenciaEntity;
import br.com.project.checkskills.entities.avaliacao.AvaliacaoEntity;
import br.com.project.checkskills.entities.dadosbasicos.FuncionarioEntity;
import br.com.project.checkskills.repositories.avaliacao.IAvaliacaoRepository;
import br.com.project.checkskills.repositories.dadosbasicos.ICompetenciaRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IEscalaRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IFuncionarioRepository;



public class AvalicaoRepositoryTest   {

	
	private static final Logger LOGGER = Logger
			.getLogger(AvalicaoRepositoryTest.class);
	
	@Inject
	private IAvaliacaoRepository avaliacaoRepository;
	
	@SuppressWarnings("unused")
	@Inject
	private ICompetenciaRepository competenciaRepository;
	
	@Inject
	private IEscalaRepository escalaRepository;
	
	@Inject
	private IFuncionarioRepository funcionarioRepository;
	
	@Test
	public void saveAvaliacaoTest(){

		List<AvaliacaoCompetenciaEntity> avaliacaoCompetencia = new ArrayList<>();
		
//		avaliacaoCompetencia.add(a1);
//		avaliacaoCompetencia.add(a2);
//		avaliacaoCompetencia.add(a3);
//		avaliacaoCompetencia.add(a4);
//		avaliacaoCompetencia.add(a5);
//		avaliacaoCompetencia.add(a6);
//		
		
		
		FuncionarioEntity avaliado = new FuncionarioEntity();
		avaliado = this.funcionarioRepository.findOne(1L);
		
		FuncionarioEntity lider = new FuncionarioEntity();
		lider = this.funcionarioRepository.findOne(2L);
		
		
		List<FuncionarioEntity>  funcionarios = new ArrayList<>();
		funcionarios.add(avaliado);
		funcionarios.add(lider);
		
		AvaliacaoEntity entity = new AvaliacaoEntity();
		entity.setAvaliacaoCompetencias(avaliacaoCompetencia);
	
	
		
		entity.setFuncionarios(funcionarios);
	
		
		this.avaliacaoRepository.save(entity);
		
		LOGGER.info(entity);
		
		
		
	}

	public IEscalaRepository getEscalaRepository() {
		return escalaRepository;
	}

	public void setEscalaRepository(IEscalaRepository escalaRepository) {
		this.escalaRepository = escalaRepository;
	}
	
}
