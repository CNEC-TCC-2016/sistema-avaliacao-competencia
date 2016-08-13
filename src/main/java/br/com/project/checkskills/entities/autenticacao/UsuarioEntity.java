package br.com.project.checkskills.entities.autenticacao;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.project.checkskills.entities.dadosbasicos.FuncionarioEntity;
import br.com.project.checkskills.utils.BaseEntity;

// declara como sendo uma Entidade no Banco
@Entity
// sobrescreve o username da tabela do BD se necessario
@Table(name = "TB_USUARIO")
// Sobrescreve o username do id em AbstractPersistable, somente quando o
// username da chave primaria � difernete do username da tabela
@AttributeOverride(name = "id", column = @Column(name = "ID_USUARIO"))
@Component(value = "usuarioEntity")
public class UsuarioEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "USERNAME", length = 120, nullable = false)
	private String username;

	@Column(name = "EMAIL", length = 255, nullable = false, unique = true)
	private String email;

	@Column(name = "PASSWORD", length = 128, nullable = false)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ASS_USUARIO_PERMISSAO", joinColumns = @JoinColumn(name = "ID_USUARIO"), inverseJoinColumns = @JoinColumn(name = "ID_PERMISSAO"))
	private List<PermissaoEntity> permissions;

	@OneToOne(mappedBy = "usuarioEntity")
	private FuncionarioEntity funcionarioEntity;

	public String getUsername() {

		return username;
	}

	public void setUsername(String nome) {

		this.username = nome;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public List<PermissaoEntity> getPermissions() {

		return permissions;
	}

	public void setPermissions(List<PermissaoEntity> permissions) {

		this.permissions = permissions;
	}

	public FuncionarioEntity getFuncionarioEntity() {

		return funcionarioEntity;
	}

	public void setFuncionarioEntity(FuncionarioEntity funcionarioEntity) {

		this.funcionarioEntity = funcionarioEntity;
	}

	public UsuarioEntity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {

		return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}

	public UsuarioEntity( String nome, String email, String password, List<PermissaoEntity> permissions, FuncionarioEntity funcionarioEntity ) {
		super();
		this.username = nome;
		this.email = email;
		this.password = password;
		this.permissions = permissions;
		this.funcionarioEntity = funcionarioEntity;
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
		UsuarioEntity other = (UsuarioEntity) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
