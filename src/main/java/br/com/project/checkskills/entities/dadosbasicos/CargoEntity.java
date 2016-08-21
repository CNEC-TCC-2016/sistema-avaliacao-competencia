package br.com.project.checkskills.entities.dadosbasicos;


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
import javax.persistence.Table;

import br.com.project.checkskills.entities.autenticacao.PermissaoEntity;
import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name = "TB_CARGO")
@AttributeOverride(name = "id", column = @Column(name = "ID_CARGO"))
public class CargoEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome_cargo", length = 45, nullable = false)
	private String nomeCargo;

	@Column(length = 255, nullable = true)
	private String descricao;

	@JoinColumn(name = "ID_NIVEL", referencedColumnName = "ID_NIVEL", nullable = false)
	@ManyToOne(optional = false)
	private NivelEntity nivelEntity;

	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name="ID_DEPARTAMENTO", referencedColumnName="ID_DEPARTAMENTO")
	private DepartamentoEntity departamento;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ASS_CARGO_COMPETENCIA", joinColumns = @JoinColumn(name = "ID_CARGO"),
	inverseJoinColumns = @JoinColumn(name = "ID_COMPETENCIA"))
	private List<CompetenciaEntity> competencias;
	
	
	
	public DepartamentoEntity getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoEntity departamento) {
		this.departamento = departamento;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	

	public NivelEntity getNivelEntity() {
		return nivelEntity;
	}

	public void setNivelEntity(NivelEntity nivelEntity) {
		this.nivelEntity = nivelEntity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public List<CompetenciaEntity> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(List<CompetenciaEntity> competencias) {
		this.competencias = competencias;
	}
	
//	public cargoModeloEntity getCargomodeloEntity() {
	//	return cargomodeloEntity;
	//}

	//public void setCargomodeloEntity(cargoModeloEntity cargomodeloEntity) {
		//this.cargomodeloEntity = cargomodeloEntity;
	//}
	
	
	@Override
	public String toString() {
	    return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}
	

}
