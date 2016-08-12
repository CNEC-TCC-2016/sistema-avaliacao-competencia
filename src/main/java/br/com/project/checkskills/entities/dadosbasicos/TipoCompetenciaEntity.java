package br.com.project.checkskills.entities.dadosbasicos;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name="TB_TIPO_COMPETENCIA")
@AttributeOverride(name="id", column=@Column(name="ID_TIPO_COMPETENCIA"))
public class TipoCompetenciaEntity extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;

	@Column(name= "TIPO_COMPETENCIA", length=45,nullable=false)
	private String nome;

//	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCompetencia")
//	 private List<CompetenciaEntity> Competencias;
	
	public TipoCompetenciaEntity() {
		
	}
	
	public TipoCompetenciaEntity(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	
}
