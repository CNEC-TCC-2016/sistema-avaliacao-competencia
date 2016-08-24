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
import br.com.project.checkskills.repositories.dadosbasicos.IDepartamentoRepository;
import br.com.project.checkskills.repositories.dadosbasicos.INivelRepository;
import br.com.project.checkskills.utils.BaseEntity;

@ManagedBean(name = "cargoBean")
@ViewScoped
public class CargoBean extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(CargoBean.class);

	@ManagedProperty(value = "#{cargoRepository}")
	private ICargoRepository cargoRepository;

	@ManagedProperty(value = "#{departamentoRepository}")
	private IDepartamentoRepository departamentoRepository;

	@ManagedProperty(value = "#{nivelRepository}")
	private INivelRepository nivelRepository;

	public List<CargoEntity> cargos;

	@ManagedProperty(value = "#{cargoEntity}")
	private CargoEntity cargoEntity;

	@ManagedProperty(value = "#{departamentoEntity}")
	private DepartamentoEntity departamentoEntity;

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
		if (this.cargoEntity.getId() == null) {
			cargoEntity.setNivelEntity(nivelSelecionado);
			this.cargoRepository.save(cargoEntity);
			Messages.addFlashGlobalInfo("Cargo Salvo com Sucesso.");

		} else {

			this.cargoRepository.save(cargoEntity);
			Messages.addFlashGlobalInfo("Cargo editado com sucesso.");

		}
		LOGGER.info(cargoEntity);
		return "/pages/cargo/cargoList.xhtml?faces-redirect=true";

	}

	public String deletar() {
		if (this.cargoEntity.getId() != null)
			this.cargoRepository.delete(this.cargoEntity.getId());
		return "/pages/cargo/cargoList.xhtml?faces-redirect=true";

	}

	public void loadCadastro() {
		try {
			if (codigo != null) {
				Long codigo = Long.parseLong(this.codigo);

				cargoEntity = new CargoEntity();
				cargoEntity = this.cargoRepository.findOne(codigo);
				LOGGER.info(cargoEntity);
				Messages.addFlashGlobalInfo("Dados carregado com sucesso.");

			}
			if (acao.equals("ADICIONAR")) {
				this.cargoEntity = new CargoEntity();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String cancel(){
		this.setCargoEntity(null);
		return "/pages/cargo/cargoList.xhtml?faces-redirect=true";
		
	}
	public String add(){
		this.cargoEntity = new CargoEntity();
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

	public IDepartamentoRepository getDepartamentoRepository() {
		return departamentoRepository;
	}

	public void setDepartamentoRepository(
			IDepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
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

	public CargoEntity getCargoEntity() {
		return cargoEntity;
	}

	public void setCargoEntity(CargoEntity cargoEntity) {
		this.cargoEntity = cargoEntity;
	}

	public DepartamentoEntity getDepartamentoEntity() {
		return departamentoEntity;
	}

	public void setDepartamentoEntity(DepartamentoEntity departamentoEntity) {
		this.departamentoEntity = departamentoEntity;
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
