package br.com.project.checkskills.entities.avaliacao;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.entities.dadosbasicos.FuncionarioEntity;
import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name="TB_AVALIACAO")
@AttributeOverride(name = "id", column = @Column(name = "ID_AVALIACAO"))
@Component(value="avaliacaoEntity")
public class AvaliacaoEntity extends BaseEntity<Long> {

	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="ID_AVALICAO",referencedColumnName="ID_AVALIACAO")
	private List<AvaliacaoCompetenciaEntity> avaliacaoCompetencias;

	
	@OneToOne( optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="ID_FUNCIONARIO")
	private FuncionarioEntity funcionario;
	
	@Column(name="STATUS")
	private Boolean status;

	
	public AvaliacaoEntity() {
	}
	
	public AvaliacaoEntity(List<AvaliacaoCompetenciaEntity> avaliacaoCompetencias) {
		super();
		this.avaliacaoCompetencias = avaliacaoCompetencias;
	}

	public List<AvaliacaoCompetenciaEntity> getAvaliacaoCompetencias() {
		return avaliacaoCompetencias;
	}

	public void setAvaliacaoCompetencias(List<AvaliacaoCompetenciaEntity> avaliacaoCompetencias) {
		this.avaliacaoCompetencias = avaliacaoCompetencias;
	}

	

	public AvaliacaoEntity(List<AvaliacaoCompetenciaEntity> avaliacaoCompetencias, FuncionarioEntity funcionario) {
		super();
		this.avaliacaoCompetencias = avaliacaoCompetencias;
		this.funcionario = funcionario;

	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	


	public FuncionarioEntity getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioEntity funcionario) {
		this.funcionario = funcionario;
	}


	
}
