package br.com.project.checkskills.entities.dadosbasicos;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name = "TB_COMPETENCIA")
@AttributeOverride(name = "id", column = @Column(name = "ID_COMPETENCIA"))
public class CompetenciaEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(length = 70, nullable = false)
	private String nome;

	@Column(length = 255, nullable = true)
	private String descricao;

	@JoinColumn(name = "ID_TIPO_COMPETENCIA", referencedColumnName = "ID_TIPO_COMPETENCIA",nullable=false)
	@ManyToOne(optional = false)
	private TipoCompetenciaEntity tipoCompetencia;
	
	public CompetenciaEntity() {
		
	}

	public CompetenciaEntity(String nome, String descrissao) {
		super();
		this.nome = nome;
		this.descricao = descrissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoCompetenciaEntity getTipoCompetencia() {
		return tipoCompetencia;
	}

	public void setTipoCompetencia(TipoCompetenciaEntity tipoCompetencia) {
		this.tipoCompetencia = tipoCompetencia;
	}
	
	@Override
	public String toString() {
	    return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}
	
	
	  
		@Override
		public int hashCode() {

			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ( ( getId() == null ) ? 0 : getId().hashCode() );
			return result;
		}

		@Override
		public boolean equals(Object obj) {

			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			CompetenciaEntity other = (CompetenciaEntity) obj;
			if (getId() == null) {
				if (other.getId() != null)
					return false;
			} else if (!getId().equals(other.getId()))
				return false;
			return true;
		}

}
