package br.com.project.checkskills.entities.compositekeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.project.checkskills.utils.BaseKey;

@Embeddable
public class UsuarioPermissaoKey extends BaseKey {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Column(name = "ID_PERMISSAO")
	private Long permissionId;

	@Column(name = "ID_USUARIO")
	private Long userId;

	public UsuarioPermissaoKey() {
	}

	public UsuarioPermissaoKey( Long permissionId, Long userId ) {
		super();
		this.permissionId = permissionId;
		this.userId = userId;
	}

	public Long getPermissionId() {

		return permissionId;
	}

	public void setPermissionId(Long permissionId) {

		this.permissionId = permissionId;
	}

	public Long getUserId() {

		return userId;
	}

	public void setUserId(Long userId) {

		this.userId = userId;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ( ( permissionId == null ) ? 0 : permissionId.hashCode() );
		result = prime * result + ( ( userId == null ) ? 0 : userId.hashCode() );
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
		UsuarioPermissaoKey other = (UsuarioPermissaoKey) obj;
		if (permissionId == null) {
			if (other.permissionId != null)
				return false;
		} else if (!permissionId.equals(other.permissionId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	

}
