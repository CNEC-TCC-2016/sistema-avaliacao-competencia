package br.com.project.checkskills.entities.avaliacao;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.entities.dadosbasicos.CicloAvaliacaoEntity;
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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ASS_FUNCIONARIO_AVALIACAO", joinColumns = 
	@JoinColumn(name = "ID_AVALIACAO"), inverseJoinColumns = 
	@JoinColumn(name = "ID_FUNCIONARIO"))
	private List<FuncionarioEntity> funcionarios;
	
	@Column(name="STATUS")
	private Boolean status;

	public List<FuncionarioEntity> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<FuncionarioEntity> funcionarios) {
		this.funcionarios = funcionarios;
	}

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

	public AvaliacaoEntity(List<AvaliacaoCompetenciaEntity> avaliacaoCompetencias, List<FuncionarioEntity> funcionarios) {
		super();
		this.avaliacaoCompetencias = avaliacaoCompetencias;
		this.funcionarios = funcionarios;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


	
}
