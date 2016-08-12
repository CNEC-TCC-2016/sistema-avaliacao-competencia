package br.com.project.checkskills.repositories.autenticacao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.checkskills.entities.autenticacao.UsuarioPermissaoEntity;
import br.com.project.checkskills.entities.compositekeys.UsuarioPermissaoKey;

public interface IUsuarioPermissaoRepository extends JpaRepository<UsuarioPermissaoEntity, 
		UsuarioPermissaoKey> {

}
