package br.com.project.checkskills.entities.dadosbasicos;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	
	
	
}
