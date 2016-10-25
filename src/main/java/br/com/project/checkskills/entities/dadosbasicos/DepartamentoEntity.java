package br.com.project.checkskills.entities.dadosbasicos;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name = "TB_DEPARTAMENTO")
@AttributeOverride(name = "id", column = @Column(name = "ID_DEPARTAMENTO"))
@Component
public class DepartamentoEntity extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Column(name = "NOME_DEPARTAMENTO")
	private String nomeDepartamento;
	

    @JoinColumn(name = "ID_ORGANIZACAO", referencedColumnName = "ID_ORGANIZACAO",nullable=false)
    @ManyToOne(optional = false)
    @NotNull
    private OrganizacaoEntity organizacao;
    
    @JoinColumn(name = "ID_DEPARTAMENTO_PAI", referencedColumnName = "ID_DEPARTAMENTO")
    @ManyToOne
    private DepartamentoEntity departamentoPai;

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	public OrganizacaoEntity getOrganizacao() {
		return organizacao;
	}

	public void setOrganizacao(OrganizacaoEntity organizacao) {
		this.organizacao = organizacao;
	}

	public DepartamentoEntity getDepartamentoPai() {
		return departamentoPai;
	}

	public void setDepartamentoPai(DepartamentoEntity departamentoPai) {
		this.departamentoPai = departamentoPai;
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
		DepartamentoEntity other = (DepartamentoEntity) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}


}
