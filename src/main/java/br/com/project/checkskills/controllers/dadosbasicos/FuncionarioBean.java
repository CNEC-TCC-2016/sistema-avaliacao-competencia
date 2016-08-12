package br.com.project.checkskills.controllers.dadosbasicos;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.com.project.checkskills.entities.autenticacao.PermissaoEntity;
import br.com.project.checkskills.entities.autenticacao.UsuarioEntity;
import br.com.project.checkskills.entities.dadosbasicos.FuncionarioEntity;
import br.com.project.checkskills.repositories.autenticacao.IPermissaoRepository;
import br.com.project.checkskills.repositories.autenticacao.IUsuarioRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IFuncionarioRepository;
import br.com.project.checkskills.utils.BaseEntity;
import br.com.project.checkskills.utils.FacesUtil;

@ManagedBean(name="funcionarioBean")
@ViewScoped
public class FuncionarioBean extends BaseEntity<Long>{

private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(FuncionarioBean.class);

	@ManagedProperty(value="#{funcionarioRepository}")
	private IFuncionarioRepository funcionarioRepository;
	
	@ManagedProperty(value="#{usuarioRepository}")
	private IUsuarioRepository usuarioRepository;
	
	private List<FuncionarioEntity> funcionarios;
	

	@ManagedProperty(value="#{funcionarioEntity}")
	private FuncionarioEntity funcionarioEntity;
	
	@ManagedProperty(value="#{usuarioEntity}")
	private UsuarioEntity usuarioEntity;
	
	@ManagedProperty(value="#{permissaoEntity}")
	private PermissaoEntity permissaoEntity;
	
	
	
	private List<PermissaoEntity> permissaoSelecionadas ;
	
	@ManagedProperty(value="#{permissaoRepository}")
	private IPermissaoRepository permissaoRepository;
	
	private Long id;
	
	
	
	//carregar lista
	public void onLoad(){
		this.funcionarios = this.funcionarioRepository.findAll();
	}

	//salvar ou atualizar
	
	public String salvarOuDeletar(){
			if(this.funcionarioEntity.getId() == null){
			//add
				this.usuarioEntity.setPermissions(permissaoSelecionadas);
				//this.usuarioEntity.setFuncionarioEntity(funcionarioEntity);
				funcionarioEntity.setUsuarioEntity(usuarioEntity);
			this.funcionarioRepository.save(funcionarioEntity);
			LOGGER.info(funcionarioEntity);
		}else {
			//atualizar
			this.funcionarioRepository.save(getFuncionarioEntity());
		}
		return "/pages/funcionario/funcionarioList.xhtml?faces-redirect=true";		
	}
	
	
	public String deletar(){
		if(this.funcionarioEntity.getId() != null)
			this.funcionarioRepository.delete(this.funcionarioEntity.getId());
		
		return "/pages/funcionario/funcionarioList.xhtml?faces-redirect=true";
	}
	
	public void loadCadastro(){
		try {
			String valor = FacesUtil.getParam("codigo");
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				funcionarioEntity = new FuncionarioEntity();
				funcionarioEntity = this.funcionarioRepository.findOne(codigo);
				usuarioEntity = funcionarioEntity.getUsuarioEntity();
				LOGGER.info(funcionarioEntity);
				LOGGER.info(usuarioEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<PermissaoEntity> loadPermissoes(){
		return this.permissaoRepository.findAll();
	}
	
	//botão cancelar
	public String cancel() {
		this.setFuncionarioEntity(null);
		return "/pages/funcionario/funcionarioList.xhtml?faces-redirect=true";
	}
	
	
	//botão adicionar
	public String add(){
		this.funcionarioEntity = null;
		return "/pages/funcionario/funcionarioAddEdit.xhtml?faces-redirect=true";
	}
	
	//botão editar
		public String editar(){
			return "/pages/funcionario/funcionarioAddEdit.xhtml?faces-redirect=true";
		}
		
		public String excluir(){
			return "/pages/funcionario/funcionarioAddEdit.xhtml?faces-redirect=true";
		}
		
		
		
		
	
	//todos get e set
	public IFuncionarioRepository getFuncionarioRepository() {
		return funcionarioRepository;
	}


	public void setFuncionarioRepository(IFuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}


	public List<FuncionarioEntity> getFuncionarios() {
		return funcionarios;
	}


	public void setFuncionarios(List<FuncionarioEntity> funcionarios) {
		this.funcionarios = funcionarios;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PermissaoEntity> getPermissaoSelecionadas() {
		if (permissaoSelecionadas == null)
			permissaoSelecionadas = new ArrayList<>();
		return permissaoSelecionadas;
	}

	public void setPermissaoSelecionadas(List<PermissaoEntity> permissaoSelecionadas) {
		this.permissaoSelecionadas = permissaoSelecionadas;
	}

	public IPermissaoRepository getPermissaoRepository() {
		return permissaoRepository;
	}

	public void setPermissaoRepository(IPermissaoRepository permissaoRepository) {
		this.permissaoRepository = permissaoRepository;
	}

	public FuncionarioEntity getFuncionarioEntity() {
		return funcionarioEntity;
	}

	public void setFuncionarioEntity(FuncionarioEntity funcionarioEntity) {
		this.funcionarioEntity = funcionarioEntity;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public PermissaoEntity getPermissaoEntity() {
		return permissaoEntity;
	}

	public void setPermissaoEntity(PermissaoEntity permissaoEntity) {
		this.permissaoEntity = permissaoEntity;
	}

	public IUsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(IUsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	

	
}
