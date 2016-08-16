package br.com.project.checkskills.controllers.dadosbasicos;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.omnifaces.util.Messages;

import br.com.project.checkskills.entities.dadosbasicos.DepartamentoEntity;
import br.com.project.checkskills.entities.dadosbasicos.OrganizacaoEntity;
import br.com.project.checkskills.repositories.dadosbasicos.IDepartamentoRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IOrganizacaoRepository;
import br.com.project.checkskills.utils.BaseEntity;

@ManagedBean(name="departamentoBean")
@ViewScoped
public class DepartamentoBean extends BaseEntity<Long>{

private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(DepartamentoBean.class);

	@ManagedProperty(value="#{departamentoRepository}")
	private IDepartamentoRepository departamentoRepository;
	
	@ManagedProperty(value="#{organizacaoRepository}")
	private IOrganizacaoRepository organizacaoRepository;

	

	@ManagedProperty(value="#{departamentoEntity}")
	private DepartamentoEntity departamentoEntity;
	
	private List<DepartamentoEntity> departamentos;
	
	private List<OrganizacaoEntity> organizacoes;
		
	private DepartamentoEntity departamentoSelecionado;
	
	private OrganizacaoEntity organizacaoSelecionado;
	
	private Long id;
	
	private String codigo;
	private String acao;
	
    private Boolean tipoCadastro;
	

	
	
	public Boolean getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(Boolean tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	//carregar lista
	public void onLoad(){
		this.departamentos = this.departamentoRepository.findAll();
	}

	//salvar ou atualizar
	
	public String salvarOuDeletar(){
			if(this.departamentoEntity.getId() == null){
			departamentoEntity.setOrganizacao(organizacaoSelecionado);
			this.departamentoRepository.save(departamentoEntity);
			Messages.addFlashGlobalInfo("Organização salva com sucesso");
		}else {
			this.departamentoRepository.save(departamentoEntity);
			Messages.addFlashGlobalInfo("Organização editada com sucesso");
		}
			LOGGER.info(departamentoEntity);
		return "/pages/departamento/departamentoList.xhtml?faces-redirect=true";		
	}
	
	
	public String deletar(){
		if(this.departamentoEntity.getId() != null)
			this.departamentoRepository.delete(this.departamentoEntity.getId());
		
		return "/pages/departamento/departamentoList.xhtml?faces-redirect=true";
	}
	
	public void loadCadastro(){
		try {
			if (codigo != null) {
				Long codigo = Long.parseLong(this.codigo);
				departamentoEntity = new DepartamentoEntity();
				departamentoEntity = this.departamentoRepository.findOne(codigo);
				LOGGER.info(departamentoEntity);
				Messages.addFlashGlobalInfo("Dados carregados com sucesso");
			}if (acao.equals("ADICIONAR")) {
				this.departamentoEntity = new DepartamentoEntity();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//botão cancelar
	public String cancel() {
		this.setDepartamentoEntity(null);
		return "/pages/departamento/departamentoList.xhtml?faces-redirect=true";
	}
	
	
	//botão adicionar
	public String add(){
		this.departamentoEntity = new DepartamentoEntity();
		this.tipoCadastro = false;
		return "/pages/departamento/departamentoAddEdit.xhtml?faces-redirect=true";
	}
	
	//botão editar
		public String editar(){
			return "/pages/departamento/departamentoAddEdit.xhtml?faces-redirect=true";
		}
		
		public String excluir(){
			return "/pages/departamento/departamentoAddEdit.xhtml?faces-redirect=true";
		}
		
		
		
		
	
	//todos get e set
	public IDepartamentoRepository getDepartamentoRepository() {
		return departamentoRepository;
	}


	public void setDepartamentoRepository(IDepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}


	public List<DepartamentoEntity> getDepartamentos() {
		return departamentos;
	}


	public void setDepartamentos(List<DepartamentoEntity> departamentos) {
		this.departamentos = departamentos;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DepartamentoEntity getDepartamentoEntity() {
		return departamentoEntity;
	}

	public void setDepartamentoEntity(DepartamentoEntity departamentoEntity) {
		this.departamentoEntity = departamentoEntity;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public DepartamentoEntity getDepartamentoSelecionado() {
		return departamentoSelecionado;
	}

	public void setDepartamentoSelecionado(DepartamentoEntity departamentoSelecionado) {
		this.departamentoSelecionado = departamentoSelecionado;
	}

	public OrganizacaoEntity getOrganizacaoSelecionado() {
		return organizacaoSelecionado;
	}

	public void setOrganizacaoSelecionado(OrganizacaoEntity organizacaoSelecionado) {
		this.organizacaoSelecionado = organizacaoSelecionado;
	}

	public IOrganizacaoRepository getOrganizacaoRepository() {
		return organizacaoRepository;
	}

	public void setOrganizacaoRepository(IOrganizacaoRepository organizacaoRepository) {
		this.organizacaoRepository = organizacaoRepository;
	}

	public List<OrganizacaoEntity> getOrganizacoes() {
	
		return this.organizacaoRepository.findAll();
	}

	public void setOrganizacoes(List<OrganizacaoEntity> organizacoes) {
		this.organizacoes = organizacoes;
	}


	
}
