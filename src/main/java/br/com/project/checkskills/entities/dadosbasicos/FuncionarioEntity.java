package br.com.project.checkskills.entities.dadosbasicos;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.entities.autenticacao.UsuarioEntity;
import br.com.project.checkskills.entities.avaliacao.AvaliacaoEntity;
import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name="TB_FUNCIONARIO")
@AttributeOverride(name = "id", column = @Column(name = "ID_FUNCIONARIO"))
@Component(value="funcionarioEntity")
public class FuncionarioEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
	
	@Column(name="NOME")
	@NotNull(message="Campo obrigatório")
	private String nome;
	
	@Column(name="SEXO")
	@NotNull(message="Campo obrigatório")
	private String sexo;
	
	@OneToOne( cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, 
			optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="ID_FUNCIONARIO")
	private UsuarioEntity usuarioEntity;

	@ManyToOne(cascade={CascadeType.MERGE}, 
			optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="ID_CARGO")
	private CargoEntity cargo;

	@OneToOne(mappedBy="funcionario")
	private AvaliacaoEntity avaliacao;

	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public CargoEntity getCargo() {
		return cargo;
	}

	public AvaliacaoEntity getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoEntity avaliacao) {
		this.avaliacao = avaliacao;
	}

	public void setCargo(CargoEntity cargo) {
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}
	
	@Override
	public String toString() {
	    return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}
	
	

}
