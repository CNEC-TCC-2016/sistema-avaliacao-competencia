package br.com.project.checkskills.entities.compositekeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.project.checkskills.utils.BaseKey;

@SuppressWarnings("serial")
@Embeddable
public class UsuarioPermissaoKey  extends BaseKey{
	
	@Column(name="ID_PERMISSAO")
	private Long permissionId;
	
	@Column(name="ID_USUARIO")
	private Long userId;

	public UsuarioPermissaoKey() {
	}

	
	public UsuarioPermissaoKey(Long permissionId, Long userId) {
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
	
	
	

}
