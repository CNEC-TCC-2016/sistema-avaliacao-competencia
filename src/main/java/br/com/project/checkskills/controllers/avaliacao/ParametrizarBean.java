package br.com.project.checkskills.controllers.avaliacao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.primefaces.model.DualListModel;

import br.com.project.checkskills.entities.dadosbasicos.CargoEntity;
import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;
import br.com.project.checkskills.repositories.avaliacao.ICargoCompetenciaRepository;
import br.com.project.checkskills.repositories.dadosbasicos.ICargoRepository;
import br.com.project.checkskills.repositories.dadosbasicos.ICompetenciaRepository;
import br.com.project.checkskills.utils.BaseEntity;

@ManagedBean(name = "ParametrizarBean")
@ViewScoped
public class ParametrizarBean extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(ParametrizarBean.class);


	
	@ManagedProperty(value="#{cargoRepository}")
	private ICargoRepository cargoRepository;
	
	@ManagedProperty(value="#{competenciaRepository}")
	private ICompetenciaRepository competenciaRepository;

	@ManagedProperty(value="#{cargoCompetenciaRepository}")
	private ICargoCompetenciaRepository cargoCompetenciaRepository;
	

	//source
	private List<CompetenciaEntity> competenciaDisponiveis ;
	//target
	private List<CompetenciaEntity> competenciaEscolhidas =  new ArrayList<>();
	
	
	private DualListModel<CompetenciaEntity> competencias;

	private String codigo;

	
	@PostConstruct
    public void init() {
		competenciaDisponiveis = this.competenciaRepository.findAll();
		 competenciaEscolhidas =  new ArrayList<>();
		competencias = new DualListModel<CompetenciaEntity>(competenciaDisponiveis, competenciaEscolhidas);
	}
	
	
	public void Salvar (){
		
		
	}
	
	//get and set
	public ICargoRepository getCargoRepository() {
		return cargoRepository;
	}


	public void setCargoRepository(ICargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}


	public ICompetenciaRepository getCompetenciaRepository() {
		return competenciaRepository;
	}


	public void setCompetenciaRepository(ICompetenciaRepository competenciaRepository) {
		this.competenciaRepository = competenciaRepository;
	}


	public List<CompetenciaEntity> getCompetenciaDisponiveis() {
		return competenciaDisponiveis;
	}


	public void setCompetenciaDisponiveis(List<CompetenciaEntity> competenciaDisponiveis) {
		this.competenciaDisponiveis = competenciaDisponiveis;
	}


	public List<CompetenciaEntity> getCompetenciaEscolhidas() {
		return competenciaEscolhidas;
	}


	public void setCompetenciaEscolhidas(List<CompetenciaEntity> competenciaEscolhidas) {
		this.competenciaEscolhidas = competenciaEscolhidas;
	}


	public DualListModel<CompetenciaEntity> getCompetencias() {
		return competencias;
	}


	public void setCompetencias(DualListModel<CompetenciaEntity> competencias) {
		this.competencias = competencias;
	}



	public ICargoCompetenciaRepository getCargoCompetenciaRepository() {
		return cargoCompetenciaRepository;
	}

	public void setCargoCompetenciaRepository(ICargoCompetenciaRepository cargoCompetenciaRepository) {
		this.cargoCompetenciaRepository = cargoCompetenciaRepository;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	
}
