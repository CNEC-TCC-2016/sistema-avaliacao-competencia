package br.com.project.checkskills.repositories.autenticacao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.checkskills.entities.compositekeys.UsuarioPermissaoKey;
import br.com.project.checkskills.entities.jointables.UsuarioPermissaoEntity;

public interface IUsuarioPermissaoRepository extends JpaRepository<UsuarioPermissaoEntity, 
		UsuarioPermissaoKey> {

}
