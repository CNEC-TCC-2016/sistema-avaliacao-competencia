package br.com.project.checkskills.entities.dadosbasicos;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.stereotype.Component;

import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name="TB_ORGANIZACAO")
@AttributeOverride(name="id",column=@Column(name="ID_ORGANIZACAO"))
@Component(value="organizacaoEntity")
public class OrganizacaoEntity extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;

	@NotNull(message="Compo obrigatório")
	@Column(name="RAZAO_SOCIAL")
	private String razaoSocial;
	
	@NotNull
	@Column(name="RAMO_ATUACAO")
	private String ramoAtuacao;

	@CNPJ(message="Dados inválidos")
	@Column(name="CNPJ")
	@NotNull 
	private String cnpj;
	

	@Column(name="TELEFONE")
	@NotNull
	private String telefone;
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getRamoAtuacao() {
		return ramoAtuacao;
	}

	public void setRamoAtuacao(String ramoAtuacao) {
		this.ramoAtuacao = ramoAtuacao;
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
		OrganizacaoEntity other = (OrganizacaoEntity) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
