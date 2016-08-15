package br.com.project.checkskills.controllers.dadosbasicos;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.omnifaces.util.Messages;

import br.com.project.checkskills.entities.dadosbasicos.OrganizacaoEntity;
import br.com.project.checkskills.repositories.dadosbasicos.IOrganizacaoRepository;
import br.com.project.checkskills.utils.BaseEntity;

@ManagedBean(name="organizacaoBean")
@ViewScoped
public class OrganizacaoBean extends BaseEntity<Long>{

private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(OrganizacaoBean.class);

	@ManagedProperty(value="#{organizacaoRepository}")
	private IOrganizacaoRepository organizacaoRepository;
	

	@ManagedProperty(value="#{organizacaoEntity}")
	private OrganizacaoEntity organizacaoEntity;
	
	private List<OrganizacaoEntity> organizacaos;
		
	
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
		this.organizacaos = this.organizacaoRepository.findAll();
	}

	//salvar ou atualizar
	
	public String salvarOuDeletar(){
			if(this.organizacaoEntity.getId() == null){
			this.organizacaoRepository.save(organizacaoEntity);
			Messages.addFlashGlobalInfo("Organização salva com sucesso");
		}else {
			this.organizacaoRepository.save(organizacaoEntity);
			Messages.addFlashGlobalInfo("Organização editada com sucesso");
		}
			LOGGER.info(organizacaoEntity);
		return "/pages/organizacao/organizacaoList.xhtml?faces-redirect=true";		
	}
	
	
	public String deletar(){
		if(this.organizacaoEntity.getId() != null)
			this.organizacaoRepository.delete(this.organizacaoEntity.getId());
		
		return "/pages/organizacao/organizacaoList.xhtml?faces-redirect=true";
	}
	
	public void loadCadastro(){
		try {
			if (codigo != null) {
				Long codigo = Long.parseLong(this.codigo);
				organizacaoEntity = new OrganizacaoEntity();
				organizacaoEntity = this.organizacaoRepository.findOne(codigo);
				LOGGER.info(organizacaoEntity);
				Messages.addFlashGlobalInfo("Dados carregados com sucesso");
			}if (acao.equals("ADICIONAR")) {
				this.organizacaoEntity = new OrganizacaoEntity();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//botão cancelar
	public String cancel() {
		this.setOrganizacaoEntity(null);
		return "/pages/organizacao/organizacaoList.xhtml?faces-redirect=true";
	}
	
	
	//botão adicionar
	public String add(){
		this.organizacaoEntity = new OrganizacaoEntity();
		return "/pages/organizacao/organizacaoAddEdit.xhtml?faces-redirect=true";
	}
	
	//botão editar
		public String editar(){
			return "/pages/organizacao/organizacaoAddEdit.xhtml?faces-redirect=true";
		}
		
		public String excluir(){
			return "/pages/organizacao/organizacaoAddEdit.xhtml?faces-redirect=true";
		}
		
		
		
		
	
	//todos get e set
	public IOrganizacaoRepository getOrganizacaoRepository() {
		return organizacaoRepository;
	}


	public void setOrganizacaoRepository(IOrganizacaoRepository organizacaoRepository) {
		this.organizacaoRepository = organizacaoRepository;
	}


	public List<OrganizacaoEntity> getOrganizacaos() {
		return organizacaos;
	}


	public void setOrganizacaos(List<OrganizacaoEntity> organizacaos) {
		this.organizacaos = organizacaos;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrganizacaoEntity getOrganizacaoEntity() {
		return organizacaoEntity;
	}

	public void setOrganizacaoEntity(OrganizacaoEntity organizacaoEntity) {
		this.organizacaoEntity = organizacaoEntity;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	

	
}
