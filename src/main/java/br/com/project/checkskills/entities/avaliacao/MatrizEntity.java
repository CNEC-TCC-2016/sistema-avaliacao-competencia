package br.com.project.checkskills.entities.avaliacao;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.entities.autenticacao.PermissaoEntity;
import br.com.project.checkskills.entities.dadosbasicos.FuncionarioEntity;
import br.com.project.checkskills.utils.BaseEntity;

//@Table
//@Entity(name = "TB_MATRIZ")
//@AttributeOverride(name = "id", column = @Column(name = "ID_MATRIZ"))
//@Component(value = "matrizCompetenciaEntity")
public class MatrizEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
//	
//	
//	@OneToMany(fetch=FetchType.EAGER)
//	@JoinColumn(name="ID_MATRIZ",referencedColumnName="ID_MATRIZ")
//	private List<AvaliacaoEntity> avaliacoes;
//
//	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "ASS_FUNCIONARIO_MATRIZ", joinColumns = 
//	@JoinColumn(name = "ID_MATRIZ"), inverseJoinColumns = 
//	@JoinColumn(name = "ID_FUNCIONARIO"))
//	private List<FuncionarioEntity> funcionarios;
//
//	
//	public MatrizEntity() {
//	
//	}
//
//
//	public MatrizEntity(List<AvaliacaoEntity> avaliacoes, List<FuncionarioEntity> funcionarios) {
//		super();
//		this.avaliacoes = avaliacoes;
//		this.funcionarios = funcionarios;
//	}
//
//
//	public List<AvaliacaoEntity> getAvaliacoes() {
//		return avaliacoes;
//	}
//
//
//	public void setAvaliacoes(List<AvaliacaoEntity> avaliacoes) {
//		this.avaliacoes = avaliacoes;
//	}
//
//
//	public List<FuncionarioEntity> getFuncionarios() {
//		return funcionarios;
//	}
//
//
//	public void setFuncionarios(List<FuncionarioEntity> funcionarios) {
//		this.funcionarios = funcionarios;
//	}
//
//
//	
//	
//	
//
}
