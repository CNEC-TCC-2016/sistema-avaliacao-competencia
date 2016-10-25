package br.com.project.checkskills.controllers.dadosbasicos;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;
import org.apache.log4j.Logger;

import br.com.project.checkskills.entities.dadosbasicos.CargoEntity;
import br.com.project.checkskills.entities.dadosbasicos.DepartamentoEntity;
import br.com.project.checkskills.entities.dadosbasicos.NivelEntity;
import br.com.project.checkskills.repositories.dadosbasicos.ICargoRepository;
import br.com.project.checkskills.repositories.dadosbasicos.INivelRepository;
import br.com.project.checkskills.utils.BaseEntity;

@ManagedBean(name = "cargoBean")
@ViewScoped
public class CargoBean extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(CargoBean.class);

	@ManagedProperty(value = "#{cargoRepository}")
	private ICargoRepository cargoRepository;

	@ManagedProperty(value = "#{nivelRepository}")
	private INivelRepository nivelRepository;

	public List<CargoEntity> cargos;

	@ManagedProperty(value = "#{cargo}")
	private CargoEntity cargo;

	@ManagedProperty(value = "#{departamentoEntity}")
	private DepartamentoEntity departamentoSelecionado;

	private NivelEntity nivelSelecionado;
	
	private List<NivelEntity> niveis;
	

	private Long id;

	private String codigo;

	private String acao;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void onLoad() {
		this.cargos = this.cargoRepository.findAll();
		this.niveis = this.nivelRepository.findAll();
	}

	public String salvarOuDeletar() {
	try {
		if (this.cargo.getId() == null) {
			atualizarItensSelecionados();
			this.cargoRepository.save(cargo);
			Messages.addFlashGlobalInfo("Dados do cargo salvo com sucesso.");
			
		} else {
			
			this.cargoRepository.save(cargo);
			Messages.addFlashGlobalInfo("Dados do cargo editado com sucesso.");
		}
	} catch (Exception ex) {
		ex.printStackTrace();
		Messages.addFlashGlobalInfo("Houve um erro ao tentar salvar", cargo.getNomeCargo());
	}
	return "/pages/cargo/cargoList.xhtml?faces-redirect=true";

	}

	public void atualizarItensSelecionados() {
		cargo.setNivelEntity(nivelSelecionado);
		cargo.setDepartamento(departamentoSelecionado);
	}

	public String deletar() {
		try{
				this.cargoRepository.delete(this.cargo.getId());
		}catch(Exception ex ){
			ex.printStackTrace();
			Messages.addFlashGlobalError("Houve um erro ao tentar deletar", cargo.getNomeCargo());
		}
		return "/pages/cargo/cargoList.xhtml?faces-redirect=true";
	}

	public void loadCadastro() {
		try {
			if (codigo != null) {
				Long codigo = Long.parseLong(this.codigo);

				cargo = new CargoEntity();
				cargo = this.cargoRepository.findOne(codigo);
				nivelSelecionado = cargo.getNivelEntity();
				departamentoSelecionado = cargo.getDepartamento();
				LOGGER.info(cargo);
				Messages.addFlashGlobalInfo("Dados carregado com sucesso.");

			}
			if (acao.equals("ADICIONAR")) {
				this.cargo = new CargoEntity();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String cancel(){
		this.setCargo(null);
		return "/pages/cargo/cargoList.xhtml?faces-redirect=true";
		
	}
	public String add(){
		this.cargo = new CargoEntity();
		return "/pages/cargo/cargoAddEdit.xhtml?faces-redirect=true";
		
		
	}
	public String editar(){
		return "/pages/cargo/cargoAddEdit.xhtml?faces-redirect=true";
		
	}
	public String excluir(){
		return "/pages/cargo/cargoAddEdit.xhtml?faces-redirect=true";
		
	}

		
		
	public ICargoRepository getCargoRepository() {
		return cargoRepository;
	}

	public void setCargoRepository(ICargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}


	public INivelRepository getNivelRepository() {
		return nivelRepository;
	}

	public void setNivelRepository(INivelRepository nivelRepository) {
		this.nivelRepository = nivelRepository;
	}

	public List<CargoEntity> getCargos() {
		return cargos;
	}

	public void setCargos(List<CargoEntity> cargos) {
		this.cargos = cargos;
	}

	public CargoEntity getCargo() {
		return cargo;
	}

	public void setCargo(CargoEntity cargoEntity) {
		this.cargo = cargoEntity;
	}


	public DepartamentoEntity getDepartamentoSelecionado() {
		return departamentoSelecionado;
	}

	public void setDepartamentoSelecionado(DepartamentoEntity departamentoSelecionado) {
		this.departamentoSelecionado = departamentoSelecionado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public NivelEntity getNivelSelecionado() {
		return nivelSelecionado;
	}

	public void setNivelSelecionado(NivelEntity nivelSelecionado) {
		this.nivelSelecionado = nivelSelecionado;
	}

	public List<NivelEntity> getNiveis() {
		return niveis;
	}

	public void setNiveis(List<NivelEntity> niveis) {
		this.niveis = niveis;
	}
	
}
