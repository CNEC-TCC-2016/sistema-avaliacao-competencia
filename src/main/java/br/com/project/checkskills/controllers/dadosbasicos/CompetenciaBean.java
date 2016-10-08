package br.com.project.checkskills.controllers.dadosbasicos;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.omnifaces.util.Messages;

import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;
import br.com.project.checkskills.entities.dadosbasicos.TipoCompetenciaEntity;
import br.com.project.checkskills.repositories.dadosbasicos.ICompetenciaRepository;
import br.com.project.checkskills.repositories.dadosbasicos.ITipoCompetenciaRepository;
import br.com.project.checkskills.utils.BaseEntity;
import report.Relatorio;
import report.RelatorioHelp;

@ManagedBean(name="competenciaBean")
@ViewScoped
public class CompetenciaBean extends BaseEntity<Long>{

private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(CompetenciaBean.class);

	@ManagedProperty(value="#{competenciaRepository}")
	private ICompetenciaRepository competenciaRepository;
	
	@ManagedProperty(value="#{tipoCompetenciaRepository}")
	private ITipoCompetenciaRepository tipoCompetenciaRepository;

	

	@ManagedProperty(value="#{competenciaEntity}")
	private CompetenciaEntity competenciaEntity;
	
	private List<CompetenciaEntity> competencias;
	
	private List<TipoCompetenciaEntity> tipoCompetencias;

	private TipoCompetenciaEntity tipoSelecionado;
	
	private Long id;
	
	private String codigo;
	private String acao;
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public void onLoad(){
		this.competencias = this.competenciaRepository.findAll();
		this.tipoCompetencias = this.tipoCompetenciaRepository.findAll();
	}

	//salvar ou atualizar
	public String salvarOuDeletar(){
		try {
			if(this.competenciaEntity.getId() == null){
				competenciaEntity.setTipoCompetencia(tipoSelecionado);
				this.competenciaRepository.save(competenciaEntity);
				Messages.addFlashGlobalInfo("Dados salvos com sucesso");
			}else {
				this.competenciaRepository.save(competenciaEntity);
				Messages.addFlashGlobalInfo("Dados editados com sucesso");
			}
		} catch (Exception e) {
			erroGenerico();
		}
		return "/pages/competencia/competenciaList.xhtml?faces-redirect=true";		
	}

	public void erroGenerico() {
		Messages.addFlashGlobalError("Houve um erro ao tentar executar essa operação ");
	}
	
	
	public String deletar(){
		if(this.competenciaEntity.getId() != null)
			this.competenciaRepository.delete(this.competenciaEntity.getId());
		
		return "/pages/competencia/competenciaList.xhtml?faces-redirect=true";
	}
	
	public void loadCadastro(){
		try {
			if (codigo != null) {
				Long codigo = Long.parseLong(this.codigo);
				competenciaEntity = new CompetenciaEntity();
				competenciaEntity = this.competenciaRepository.findOne(codigo);
				LOGGER.info(competenciaEntity);
				Messages.addFlashGlobalInfo("Dados carregados com sucesso");
			}if (acao.equals("ADICIONAR")) {
				this.competenciaEntity = new CompetenciaEntity();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void gerarRelatorio(){
		try {
			new RelatorioHelp().gerarRelatorio(competencias);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//botão cancelar
	public String cancel() {
		this.setCompetenciaEntity(null);
		return "/pages/competencia/competenciaList.xhtml?faces-redirect=true";
	}
	
	
	//botão adicionar
	public String add(){
		this.competenciaEntity = new CompetenciaEntity();
		return "/pages/competencia/competenciaAddEdit.xhtml?faces-redirect=true";
	}
	
	//botão editar
		public String editar(){
			return "/pages/competencia/competenciaAddEdit.xhtml?faces-redirect=true";
		}
		
		public String excluir(){
			return "/pages/competencia/competenciaAddEdit.xhtml?faces-redirect=true";
		}
		
		
		
		
	
	//todos get e set
	public ICompetenciaRepository getCompetenciaRepository() {
		return competenciaRepository;
	}


	public void setCompetenciaRepository(ICompetenciaRepository competenciaRepository) {
		this.competenciaRepository = competenciaRepository;
	}


	public List<CompetenciaEntity> getCompetencias() {
		return competencias;
	}


	public void setCompetencias(List<CompetenciaEntity> competencias) {
		this.competencias = competencias;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CompetenciaEntity getCompetenciaEntity() {
		return competenciaEntity;
	}

	public void setCompetenciaEntity(CompetenciaEntity competenciaEntity) {
		this.competenciaEntity = competenciaEntity;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}


	

	public ITipoCompetenciaRepository getTipoCompetenciaRepository() {
		return tipoCompetenciaRepository;
	}

	public void setTipoCompetenciaRepository(ITipoCompetenciaRepository tipoCompetenciaRepository) {
		this.tipoCompetenciaRepository = tipoCompetenciaRepository;
	}

	public List<TipoCompetenciaEntity> getTipoCompetencias() {
		return tipoCompetencias;
	}

	public void setTipoCompetencias(List<TipoCompetenciaEntity> tipoCompetencias) {
		this.tipoCompetencias = tipoCompetencias;
	}

	public TipoCompetenciaEntity getTipoSelecionado() {
		return tipoSelecionado;
	}

	public void setTipoSelecionado(TipoCompetenciaEntity tipoSelecionado) {
		this.tipoSelecionado = tipoSelecionado;
	}


	
}
