package br.com.project.checkskills.entities.dadosbasicos;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	

    @JoinColumn(name = "ID_ORGANIZACAO", referencedColumnName = "ID_ORGANIZACAO")
    @ManyToOne(optional = false)
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
    
    
    

}
