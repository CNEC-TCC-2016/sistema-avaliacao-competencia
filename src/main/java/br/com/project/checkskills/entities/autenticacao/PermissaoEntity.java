
package br.com.project.checkskills.entities.autenticacao;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name="TB_PERMISSAO")
@AttributeOverride(name="id", column=@Column(name="ID_PERMISSAO"))
public class PermissaoEntity extends BaseEntity<Long>{

	
	private static final long serialVersionUID = 1L;
	
	@Column(name="role", length=45, nullable=false, unique=true)
	private String role;

	
	public PermissaoEntity() {
	}

	
	public PermissaoEntity(String role) {
		super();
		this.role = role;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
	    return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PermissaoEntity other = (PermissaoEntity) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}

	

	
	
	
}