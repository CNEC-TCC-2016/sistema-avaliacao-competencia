
/**
 * @author LUAN LUCAS
 *
 */
package br.com.project.checkskills.entities.autenticacao;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.project.checkskills.entities.compositekeys.UsuarioPermissaoKey;
import br.com.project.checkskills.utils.BaseEntity;

@Entity
@Table(name= "ASS_USUARIO_PERMISSAO")
public class UsuarioPermissaoEntity extends  BaseEntity<UsuarioPermissaoKey>{

	private static final long serialVersionUID = 1L;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
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
		PermissaoEntity other = (PermissaoEntity) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}
}