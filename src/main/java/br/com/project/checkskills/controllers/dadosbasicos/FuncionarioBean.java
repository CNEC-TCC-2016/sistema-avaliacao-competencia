package br.com.project.checkskills.controllers.dadosbasicos;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.com.project.checkskills.entities.autenticacao.PermissaoEntity;
import br.com.project.checkskills.entities.autenticacao.UsuarioEntity;
import br.com.project.checkskills.entities.dadosbasicos.CargoEntity;
import br.com.project.checkskills.entities.dadosbasicos.DepartamentoEntity;
import br.com.project.checkskills.entities.dadosbasicos.FuncionarioEntity;
import br.com.project.checkskills.repositories.autenticacao.IPermissaoRepository;
import br.com.project.checkskills.repositories.autenticacao.IUsuarioRepository;
import br.com.project.checkskills.repositories.dadosbasicos.ICargoRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IDepartamentoRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IFuncionarioRepository;
import br.com.project.checkskills.utils.BaseEntity;

@ManagedBean(name = "funcionarioBean")
@ViewScoped
public class FuncionarioBean extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(FuncionarioBean.class);

	@ManagedProperty(value = "#{funcionarioRepository}")
	private IFuncionarioRepository funcionarioRepository;

	@ManagedProperty(value = "#{usuarioRepository}")
	private IUsuarioRepository usuarioRepository;

	private List<FuncionarioEntity> funcionarios;
	
	private List<DepartamentoEntity> departamentos;

	@ManagedProperty(value = "#{funcionarioEntity}")
	private FuncionarioEntity funcionarioEntity;

	@ManagedProperty(value = "#{usuarioEntity}")
	private UsuarioEntity usuarioEntity;

	@ManagedProperty(value = "#{permissaoEntity}")
	private PermissaoEntity permissaoEntity;

	private List<PermissaoEntity> permissaoSelecionadas;

	//private DepartamentoEntity departamentoSelecionado;
	private CargoEntity cargoSelecionado;
	
	private List<CargoEntity> cargos;
	
	@ManagedProperty(value = "#{permissaoRepository}")
	private IPermissaoRepository permissaoRepository;

	@ManagedProperty(value="#{departamentoRepository}")
	private IDepartamentoRepository departamentoRepository;
	
	@ManagedProperty(value="#{cargoRepository}")
	private ICargoRepository cargoRepository;
	
	private Long id;

	private String codigo;
	
	private String acao;

	// carregar lista
	public void onLoad() {
		this.funcionarios = this.funcionarioRepository.findAll();
		this.departamentos = this.departamentoRepository.findAll();
		this.cargos = this.cargoRepository.findAll();
	}

	// salvar ou atualizar

	public String salvarOuDeletar() {
		atualizaModificacoesFuncionario();
			this.funcionarioRepository.save(funcionarioEntity);
		
			return "/pages/funcionario/funcionarioList.xhtml?faces-redirect=true";
	}

	public void atualizaModificacoesFuncionario() {
		this.usuarioEntity.setPermissions(permissaoSelecionadas);
		funcionarioEntity.setUsuarioEntity(usuarioEntity);
		funcionarioEntity.setCargo(cargoSelecionado);
		//funcionarioEntity.setDepartamento(departamentoSelecionado);
	}

	public String deletar() {
		if (this.funcionarioEntity.getId() != null)
			this.funcionarioRepository.delete(this.funcionarioEntity.getId());
		return "/pages/funcionario/funcionarioList.xhtml?faces-redirect=true";
	}

	public void loadCadastro() {
		try {

			if (this.codigo != null) {
				Long codigo = Long.parseLong(this.codigo);
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

	public List<PermissaoEntity> loadPermissoes() {
		return this.permissaoRepository.findAll();
	}

	// botão cancelar
	public String cancel() {
		this.setFuncionarioEntity(null);
		return "/pages/funcionario/funcionarioList.xhtml?faces-redirect=true";
	}

	// botão adicionar
	public String add() {
		this.funcionarioEntity = null;
		return "/pages/funcionario/funcionarioAddEdit.xhtml?faces-redirect=true";
	}

	// botão editar
	public String editar() {
		return "/pages/funcionario/funcionarioAddEdit.xhtml?faces-redirect=true";
	}

	public String excluir() {
		return "/pages/funcionario/funcionarioAddEdit.xhtml?faces-redirect=true";
	}

	// todos get e set
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
		if (usuarioEntity.getId() != null)
			permissaoSelecionadas = new ArrayList<>(usuarioEntity.getPermissions());
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

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
//
//	public DepartamentoEntity getDepartamentoSelecionado() {
//		return departamentoSelecionado;
//	}
//
//	public void setDepartamentoSelecionado(DepartamentoEntity departamentoSelecionado) {
//		this.departamentoSelecionado = departamentoSelecionado;
//	}

	public List<DepartamentoEntity> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<DepartamentoEntity> departamentos) {
		this.departamentos = departamentos;
	}

	public IDepartamentoRepository getDepartamentoRepository() {
		return departamentoRepository;
	}

	public void setDepartamentoRepository(IDepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}


	public CargoEntity getCargoSelecionado() {
		return cargoSelecionado;
	}

	public void setCargoSelecionado(CargoEntity cargoSelecionado) {
		this.cargoSelecionado = cargoSelecionado;
	}

	public List<CargoEntity> getCargos() {
		return cargos;
	}

	public void setCargos(List<CargoEntity> cargos) {
		this.cargos = cargos;
	}
	

	public ICargoRepository getCargoRepository() {
		return cargoRepository;
	}

	public void setCargoRepository(ICargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

}
