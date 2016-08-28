package br.com.project.checkskills.controllers.avaliacao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.omnifaces.util.Messages;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.project.checkskills.entities.avaliacao.AvaliacaoCompetenciaEntity;
import br.com.project.checkskills.entities.avaliacao.AvaliacaoEntity;
import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;
import br.com.project.checkskills.entities.dadosbasicos.EscalaEntity;
import br.com.project.checkskills.entities.dadosbasicos.FuncionarioEntity;
import br.com.project.checkskills.entities.jointables.CargoCompetenciaEntity;
import br.com.project.checkskills.repositories.autenticacao.IUsuarioRepository;
import br.com.project.checkskills.repositories.avaliacao.IAvaliacaoRepository;
import br.com.project.checkskills.repositories.avaliacao.ICargoCompetenciaRepository;
import br.com.project.checkskills.repositories.dadosbasicos.ICompetenciaRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IEscalaRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IFuncionarioRepository;
import br.com.project.checkskills.utils.BaseEntity;

@ManagedBean(name="avaliacaoBean")
@ViewScoped
public class AvaliacaoBean extends BaseEntity<Long>{

private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(AvaliacaoBean.class);

	@ManagedProperty(value="#{avaliacaoRepository}")
	private IAvaliacaoRepository avaliacaoRepository;
	

	@ManagedProperty(value="#{avaliacaoEntity}")
	private AvaliacaoEntity avaliacaoEntity;
	
	@ManagedProperty(value="#{competenciaRepository}")
	private ICompetenciaRepository competenciaRepository;

	@ManagedProperty(value="#{usuarioRepository}")
	private IUsuarioRepository usuarioRepository;
	

	@ManagedProperty(value="#{escalaRepository}")
	private IEscalaRepository escalaRepository;

	@ManagedProperty(value="#{funcionarioRepository}")
	private IFuncionarioRepository funcionarioRepository;

	@ManagedProperty(value="#{cargoCompetenciaRepository}")
	private ICargoCompetenciaRepository cargoCompetenciaRepository;


	private List<EscalaEntity> escalas;
	private List<CompetenciaEntity> competencias;
	private List<AvaliacaoEntity> avaliacaos;
	private List<AvaliacaoCompetenciaEntity> avaliacaoCompetencia;
	private List<AvaliacaoEntity> avaliacaosTemp;
	private List <FuncionarioEntity> funcionarioColecao;
	
	
	private Long id;
	
	private String codigo;
	private String acao;
    
	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	//carregar lista
	public void onLoad(){
		//this.avaliacaos = this.avaliacaoRepository.findAll();
		this.escalas = this.escalaRepository.findAll();
		this.gerarMatrizFunPorDepartamento();
	}

	public void gerarMatrizFunPorDepartamento() {
		FuncionarioEntity entity= this.funcionarioRepository.findOne(isLider().getId());
		entity.getCargo().getDepartamento();
		funcionarioColecao = this.funcionarioRepository.procuraEmDepartamentos(entity.getCargo().getDepartamento().getId());
		funcionarioColecao = new ArrayList<>( new HashSet<FuncionarioEntity>(funcionarioColecao));
		
	}

	
	
	
	
	//salvar ou atualizar
	public String salvarOuDeletar(){
			if(this.avaliacaoEntity.getId() == null){
			this.avaliacaoRepository.save(avaliacaoEntity);
			Messages.addFlashGlobalInfo("Avaliação salva com sucesso");
		}else {
			this.avaliacaoRepository.save(avaliacaoEntity);
			Messages.addFlashGlobalInfo("Avaliação editada com sucesso");
		}
			LOGGER.info(avaliacaoEntity);
		return "/pages/avaliacao/avaliacaoList.xhtml?faces-redirect=true";		
	}
	
	//salva avaliacao temporariamente
	public void salvarAvaliacao(){
		AvaliacaoEntity item = new AvaliacaoEntity(avaliacaoCompetencia, obterFuncionariosAvaliado());
		item.setStatus(true);
		this.avaliacaoRepository.save(item);
		LOGGER.info(item);
	}

	public List<FuncionarioEntity> obterFuncionariosAvaliado() {
		List<FuncionarioEntity> funcionarios = new ArrayList<>();
		funcionarios.add(isLider());
		funcionarios.add(isAvaliado());
		return funcionarios;
	}


	public FuncionarioEntity isAvaliado(){
		Long valor = Long.parseLong(codigo);
		return this.funcionarioRepository.findOne(valor);
	}
	
	//Obtem o funcionario Lider
	public FuncionarioEntity isLider(){
		String username =  SecurityContextHolder.getContext().getAuthentication().getName();
		return this.usuarioRepository.findByUsername(username).getFuncionarioEntity();
	}
	
	public String deletar(){
		if(this.avaliacaoEntity.getId() != null)
			this.avaliacaoRepository.delete(this.avaliacaoEntity.getId());
		
		return "/pages/avaliacao/avaliacaoList.xhtml?faces-redirect=true";
	}
	

	public void loadCadastro(){
		try {
			if (codigo != null) {
				Long codigo = Long.parseLong(this.codigo);
				avaliacaoEntity = new AvaliacaoEntity();
				avaliacaoEntity = this.avaliacaoRepository.findOne(codigo);
				LOGGER.info(avaliacaoEntity);
				Messages.addFlashGlobalInfo("Dados carregados com sucesso");
			}if (acao.equals("ADICIONAR")) {
				this.avaliacaoEntity = new AvaliacaoEntity();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	**Botões de link, quando se trabalha com @ViewScoped é bom usar
	**/
	//botão cancelar
	public String cancel() {
		this.setAvaliacaoEntity(null);
		return "/pages/avaliacao/avaliacaoList.xhtml?faces-redirect=true";
	}
	
	
	//botão adicionar
	public String add(){
		this.avaliacaoEntity = new AvaliacaoEntity();
		return "/pages/avaliacao/avaliacaoAddEdit.xhtml?faces-redirect=true";
	}
	
	//botão editar
		public String editar(){
			return "/pages/avaliacao/avaliacaoAddEdit.xhtml?faces-redirect=true";
		}
		
		public String excluir(){
			return "/pages/avaliacao/avaliacaoAddEdit.xhtml?faces-redirect=true";
		}
		
	
	
	//todos get e set
	public IAvaliacaoRepository getAvaliacaoRepository() {
		return avaliacaoRepository;
	}


	public void setAvaliacaoRepository(IAvaliacaoRepository avaliacaoRepository) {
		this.avaliacaoRepository = avaliacaoRepository;
	}


	public List<AvaliacaoEntity> getAvaliacaos() {
		return avaliacaos;
	}


	public void setAvaliacaos(List<AvaliacaoEntity> avaliacaos) {
		this.avaliacaos = avaliacaos;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AvaliacaoEntity getAvaliacaoEntity() {
		return avaliacaoEntity;
	}

	public void setAvaliacaoEntity(AvaliacaoEntity avaliacaoEntity) {
		this.avaliacaoEntity = avaliacaoEntity;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
	

	public ICompetenciaRepository getCompetenciaRepository() {
		return competenciaRepository;
	}

	public void setCompetenciaRepository(ICompetenciaRepository competenciaRepository) {
		this.competenciaRepository = competenciaRepository;
	}


	public List<EscalaEntity> getEscalas() {
		return escalas;
	}

	public void setEscalas(List<EscalaEntity> escalas) {
		this.escalas = escalas;
	}

	public List<CompetenciaEntity> getCompetencias() {
		return competencias ;
	}

	public void setCompetencias(List<CompetenciaEntity> competencias) {
		this.competencias = competencias;
	}



	
	public IEscalaRepository getEscalaRepository() {
		return escalaRepository;
	}

	public void setEscalaRepository(IEscalaRepository escalaRepository) {
		this.escalaRepository = escalaRepository;
	}

	/** <p> Prenche o formulário de avaliação com base no cargo que o funcionario possui</p>
	 * 
	 * **/
	public void loadForm(){
		if (acao.equals("AVALIAR")) {
			List<CargoCompetenciaEntity> cargoCompetencias = this.cargoCompetenciaRepository.findAll();
			avaliacaoCompetencia = new ArrayList<AvaliacaoCompetenciaEntity>();	
			cargoCompetencias.forEach(cargoCompetencia -> popularFomPorCargo(cargoCompetencia));
		}
		
	}

	public void popularFomPorCargo(CargoCompetenciaEntity cargoCompetencia) throws NumberFormatException {
		if (cargoCompetencia.getId().getCarogId() == funcionarioRepository.findOne( Long.parseLong(codigo))
				.getCargo().getId() ) {
			AvaliacaoCompetenciaEntity item = 
					new AvaliacaoCompetenciaEntity(new EscalaEntity(), cargoCompetencia);
			avaliacaoCompetencia.add(item);
		}
	}
	
	public List<AvaliacaoCompetenciaEntity> getAvaliacaoCompetencia() {
		//loadForm();
		return avaliacaoCompetencia;
	}

	public void setAvaliacaoCompetencia(List<AvaliacaoCompetenciaEntity> avaliacaoCompetencia) {
		this.avaliacaoCompetencia = avaliacaoCompetencia;
	}

	public List<AvaliacaoEntity> getAvaliacaosTemp() {
		if (avaliacaosTemp == null)
			avaliacaosTemp = new ArrayList<>();
		return avaliacaosTemp;
	}

	public void setAvaliacaosTemp(List<AvaliacaoEntity> avaliacaosTemp) {
		this.avaliacaosTemp = avaliacaosTemp;
	}
	
	public IUsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(IUsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}


	public IFuncionarioRepository getFuncionarioRepository() {
		return funcionarioRepository;
	}

	public void setFuncionarioRepository(IFuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public List <FuncionarioEntity> getFuncionarioColecao() {
			return funcionarioColecao;
	}

	public void setFuncionarioColecao(List <FuncionarioEntity> funcionarioColecao) {
		this.funcionarioColecao = funcionarioColecao;
	}
	

	public ICargoCompetenciaRepository getCargoCompetenciaRepository() {
		return cargoCompetenciaRepository;
	}

	public void setCargoCompetenciaRepository(ICargoCompetenciaRepository cargoCompetenciaRepository) {
		this.cargoCompetenciaRepository = cargoCompetenciaRepository;
	}


}
